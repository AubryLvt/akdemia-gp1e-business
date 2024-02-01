package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;

public class InterSessionMediumDTO extends InterSessionBasicDTO {
    private TrainerBasicDTO trainer;
    private TrainingBasicDTO training;

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
