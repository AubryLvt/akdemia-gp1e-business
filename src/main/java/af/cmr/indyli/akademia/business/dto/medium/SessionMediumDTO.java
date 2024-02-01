package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.entity.Manager;
import af.cmr.indyli.akademia.business.entity.Trainer;
import af.cmr.indyli.akademia.business.entity.Training;

public abstract class SessionMediumDTO extends SessionBasicDTO {
    private TrainerBasicDTO trainer;
    private TrainingBasicDTO training;

    public SessionMediumDTO() {
    }

    public TrainerBasicDTO getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerBasicDTO trainer) {
        this.trainer = trainer;
    }

    public TrainingBasicDTO getTraining() {
        return training;
    }

    public void setTraining(TrainingBasicDTO training) {
        this.training = training;
    }
}