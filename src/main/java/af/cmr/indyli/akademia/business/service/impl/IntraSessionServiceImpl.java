package af.cmr.indyli.akademia.business.service.impl;


import af.cmr.indyli.akademia.business.dao.IntraSessionRepository;
import af.cmr.indyli.akademia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akademia.business.entity.IntraSession;
import af.cmr.indyli.akademia.business.entity.Status;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IntraSessionService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.DateUtils;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
public class IntraSessionServiceImpl extends AbstractAkdemiaServiceImpl<IntraSession, IntraSessionBasicDTO, IntraSessionFullDTO, IntraSessionRepository> implements IntraSessionService {

    @Resource(name = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
    private IntraSessionRepository intraSessionRepository;


    public IntraSessionServiceImpl() {
        super(IntraSession.class, IntraSessionBasicDTO.class, IntraSessionFullDTO.class);
    }

    @Override
    public IntraSessionFullDTO create(IntraSessionFullDTO view) throws AkdemiaBusinessException {
        IntraSession sessionExisting = this.getDAO().findByCode(view.getCode());
        if (sessionExisting != null) {
            throw new AkdemiaBusinessException(ReglesGestion.RG03);
        }

        if (view.getDate() == null) {
            throw new AkdemiaBusinessException(ReglesGestion.RG09);
        }

        if (DateUtils.calculateDateDifferenceInDays(new Date(), view.getDate()) < 90)
            throw new AkdemiaBusinessException(ReglesGestion.RG12);

        view.setCreationDate(new Date());
        view.setStatus(Status.WAITING);
        IntraSession tmpSession = this.getDAO().saveAndFlush(this.getModelMapper().map(view, IntraSession.class));

        return this.getModelMapper().map(tmpSession, IntraSessionFullDTO.class);
    }

    @Override
    public IntraSessionFullDTO update(IntraSessionFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        IntraSession entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
        if (entity != null) {
            boolean isCodeExist = this.findAll().stream().anyMatch(p -> viewToUpdate.getCode().equals(p.getCode()) && !viewToUpdate.getId().equals(p.getId()));

            if (isCodeExist) throw new AkdemiaBusinessException(ReglesGestion.RG03);

            if (viewToUpdate.getDate() == null) throw new AkdemiaBusinessException(ReglesGestion.RG09);

            if (DateUtils.calculateDateDifferenceInDays(new Date(), viewToUpdate.getDate()) < 90)
                throw new AkdemiaBusinessException(ReglesGestion.RG12);

            viewToUpdate.setUpdateDate(new Date());
            this.getDAO().saveAndFlush(this.getModelMapper().map(viewToUpdate, IntraSession.class));
        } else {
            throw new AkdemiaBusinessException("L'objet à modifier N'existe pas en Base...");
        }

        return viewToUpdate;
    }

    @Override
    public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
        this.getDAO().findById(id).ifPresent(p -> {
            p.setStatus(Status.CANCELLED);
            this.getDAO().saveAndFlush(p);
        });
    }

    @Override
    public void deleteForce(int id) {
        this.getDAO().deleteById(id);
    }

    @Override
    public IntraSessionRepository getDAO() {
        return this.intraSessionRepository;
    }

}
