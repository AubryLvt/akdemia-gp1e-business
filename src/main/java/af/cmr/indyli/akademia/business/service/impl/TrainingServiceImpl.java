package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.TrainingRepository;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akademia.business.entity.Training;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.ITrainingService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
public class TrainingServiceImpl extends AbstractAkdemiaServiceImpl<Training, TrainingBasicDTO, TrainingFullDTO, TrainingRepository> implements ITrainingService {

    @Resource(name = ConstsValues.ConstsDAO.TRAINING_DAO_KEY)
    private TrainingRepository trainingRepository;

    public TrainingServiceImpl() {
        super(Training.class, TrainingBasicDTO.class, TrainingFullDTO.class);
    }

    @Override
    public TrainingRepository getDAO() {
        return this.trainingRepository;
    }

    @Override
    public TrainingFullDTO create(TrainingFullDTO view) throws AkdemiaBusinessException {
        Training training = this.getDAO().findByTitle(view.getTitle());
        if (training == null) {
            view.setCreationDate(new Date());
            Training entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Training.class));
            view.setId(entity.getId());
            return view;
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG04);
    }

    @Override
    public TrainingFullDTO update(TrainingFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        boolean isTrainingExist = this.findAll().stream().anyMatch(p -> viewToUpdate.getTitle().equals(p.getTitle()) && !viewToUpdate.getId().equals(p.getId()));
        if (!isTrainingExist) {
            viewToUpdate.setUpdateDate(new Date());
            Training entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
            if (entity != null) {
                this.getDAO().saveAndFlush(this.getModelMapper().map(viewToUpdate, Training.class));
            } else {
                throw new AkdemiaBusinessException("L'objet à modifier N'existe pas en Base...");
            }
            return viewToUpdate;
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG04);
    }

    @Override
    public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
        var tmpTraining = this.findById(id);

        if (tmpTraining == null) {
            throw new AkdemiaBusinessException("L'objet à supprimer n'existe pas en Base...");
        } else if (!tmpTraining.getSessions().isEmpty()) {
            throw new AkdemiaBusinessException(ReglesGestion.RG18);
        }

        getDAO().deleteById(id);
    }
}

