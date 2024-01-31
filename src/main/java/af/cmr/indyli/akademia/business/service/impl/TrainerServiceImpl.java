package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.TrainerRepository;
import af.cmr.indyli.akademia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akademia.business.entity.Trainer;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.ITrainerService;
import af.cmr.indyli.akademia.business.service.IUserService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
public class TrainerServiceImpl extends AbstractAkdemiaServiceImpl<Trainer, TrainerBasicDTO, TrainerFullDTO, TrainerRepository> implements ITrainerService {

    @Resource(name = ConstsValues.ConstsDAO.TRAINER_DAO_KEY)
    private TrainerRepository trainerRepository;

    @Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
    private IUserService userService;

    public TrainerServiceImpl() {
        super(Trainer.class, TrainerBasicDTO.class, TrainerFullDTO.class);
    }

    @Override
    public TrainerRepository getDAO() {
        return this.trainerRepository;
    }

    @Override
    public TrainerFullDTO create(TrainerFullDTO view) throws AkdemiaBusinessException {
        if (!userService.isExistUserByEmail(view.getEmail())) {
            view.setCreationDate(new Date());
            Trainer entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Trainer.class));

            return this.getModelMapper().map(entity, TrainerFullDTO.class);
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG02);
    }

    @Override
    public TrainerFullDTO update(TrainerFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
            viewToUpdate.setUpdateDate(new Date());
            Trainer entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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
        var tmpTrainer = this.findById(id);

        if (tmpTrainer == null) {
            throw new AkdemiaBusinessException("L'objet à supprimer n'existe pas en Base...");
        } else if (!tmpTrainer.getSessions().isEmpty()) {
            throw new AkdemiaBusinessException(ReglesGestion.RG17);
        }

        getDAO().deleteById(id);
    }
}