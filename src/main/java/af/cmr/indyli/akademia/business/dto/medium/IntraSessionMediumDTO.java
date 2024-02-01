package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;

public class IntraSessionMediumDTO extends IntraSessionBasicDTO {
    private TrainerBasicDTO trainer;
    private TrainingBasicDTO training;
    private CompanyBasicDTO company;

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

    public CompanyBasicDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyBasicDTO company) {
        this.company = company;
    }
}
