package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.TrainerRepository;
import af.cmr.indyli.akademia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akademia.business.entity.Trainer;

public interface ITrainerService extends IAbstractAkdemiaService<Trainer, TrainerBasicDTO, TrainerFullDTO, TrainerRepository> {
}