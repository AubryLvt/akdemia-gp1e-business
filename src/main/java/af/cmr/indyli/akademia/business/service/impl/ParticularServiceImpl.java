package af.cmr.indyli.akademia.business.service.impl;


import af.cmr.indyli.akademia.business.dao.ParticularRepository;
import af.cmr.indyli.akademia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ParticularFullDTO;
import af.cmr.indyli.akademia.business.entity.Particular;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IParticularService;
import af.cmr.indyli.akademia.business.service.IUserService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.PARTICULAR_SERVICE_KEY)
public class ParticularServiceImpl extends AbstractAkdemiaServiceImpl<Particular, ParticularBasicDTO, ParticularFullDTO, ParticularRepository> implements IParticularService {
    @Resource(name = ConstsValues.ConstsDAO.PARTICULAR_DAO_KEY)
    private ParticularRepository particularRepository;

    @Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
    private IUserService userService;

    public ParticularServiceImpl() {
        super(Particular.class, ParticularBasicDTO.class, ParticularFullDTO.class);
    }

    @Override
    public ParticularRepository getDAO() {
        return this.particularRepository;
    }

    @Override
    public ParticularFullDTO create(ParticularFullDTO view) throws AkdemiaBusinessException {
        if (!userService.isExistUserByEmail(view.getEmail())) {
            view.setCreationDate(new Date());
            Particular entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Particular.class));

            return this.getModelMapper().map(entity, ParticularFullDTO.class);
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG02);
    }

    @Override
    public ParticularFullDTO update(ParticularFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
            viewToUpdate.setUpdateDate(new Date());
            Particular entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
            if (entity != null) {
                BeanUtils.copyProperties(viewToUpdate, entity);
                this.getDAO().saveAndFlush(entity);
            } else {
                throw new AkdemiaBusinessException("L'objet à modifier N'existe pas en Base...");
            }
            return viewToUpdate;
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG02);
    }

    @Override
    public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
        var tmpParticipant = this.findById(id);

        if (tmpParticipant == null) {
            throw new AkdemiaBusinessException("L'objet à supprimer n'existe pas en Base...");
        } else if (!tmpParticipant.getParticularSubscriptions().isEmpty()) {
            throw new AkdemiaBusinessException(ReglesGestion.RG16);
        }

        getDAO().deleteById(id);
    }
}
