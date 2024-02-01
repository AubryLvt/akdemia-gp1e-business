package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.InterSessionRepository;
import af.cmr.indyli.akademia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akademia.business.entity.InterSession;
import af.cmr.indyli.akademia.business.entity.Status;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.InterSessionService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.DateUtils;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
public class InterSessionServiceImpl extends AbstractAkdemiaServiceImpl<InterSession, InterSessionBasicDTO, InterSessionFullDTO, InterSessionRepository> implements InterSessionService {

    @Resource(name = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
    private InterSessionRepository interSessionRepository;

    public InterSessionServiceImpl() {
        super(InterSession.class, InterSessionBasicDTO.class, InterSessionFullDTO.class);

    }

    @Override
    public InterSessionRepository getDAO() {
        return this.interSessionRepository;
    }

    @Override
    public InterSessionFullDTO create(InterSessionFullDTO view) throws AkdemiaBusinessException {
        InterSession sessionExisting = this.getDAO().findByCode(view.getCode());
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

        InterSession tmpSession = this.getDAO().saveAndFlush(this.getModelMapper().map(view, InterSession.class));

        return this.getModelMapper().map(tmpSession, InterSessionFullDTO.class);
    }

    @Override
    public InterSessionFullDTO update(InterSessionFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        InterSession entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);


        if (entity != null) {
            boolean isTrainerChange = !viewToUpdate.getTrainer().getId().equals(entity.getTrainer().getId());
            boolean isDateNear = DateUtils.calculateDateDifferenceInDays(viewToUpdate.getDate(), new Date()) <= 15;
            boolean isCodeExist = this.findAll().stream().anyMatch(p -> viewToUpdate.getCode().equals(p.getCode()) && !viewToUpdate.getId().equals(p.getId()));

            if (isCodeExist) throw new AkdemiaBusinessException(ReglesGestion.RG03);

            if (viewToUpdate.getDate() == null) throw new AkdemiaBusinessException(ReglesGestion.RG09);

            if (DateUtils.calculateDateDifferenceInDays(new Date(), viewToUpdate.getDate()) < 90)
                throw new AkdemiaBusinessException(ReglesGestion.RG12);

            if (isTrainerChange && isDateNear) {
                throw new AkdemiaBusinessException(ReglesGestion.RG10);
            }

            viewToUpdate.setUpdateDate(new Date());
            this.getDAO().saveAndFlush(this.getModelMapper().map(viewToUpdate, InterSession.class));
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
}
