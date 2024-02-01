package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.TrainingRepository;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akademia.business.entity.Training;

public interface ITrainingService extends IAbstractAkdemiaService<Training, TrainingBasicDTO, TrainingFullDTO, TrainingRepository> {
}