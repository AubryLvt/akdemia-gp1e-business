package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.PlanificationBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.entity.Company;
import af.cmr.indyli.akademia.business.entity.Training;

public class PlanificationMediumDTO extends PlanificationBasicDTO {
    private CompanyBasicDTO company;
    private TrainingBasicDTO training;

    public PlanificationMediumDTO() {
    }

    public PlanificationMediumDTO(CompanyBasicDTO company) {
        this.company = company;
    }

    public CompanyBasicDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyBasicDTO company) {
        this.company = company;
    }

    public TrainingBasicDTO getTraining() {
        return training;
    }

    public void setTraining(TrainingBasicDTO training) {
        this.training = training;
    }
}
