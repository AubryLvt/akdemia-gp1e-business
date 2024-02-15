package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.PlanificationBasicDTO;

public class PlanificationMediumDTO extends PlanificationBasicDTO {

    // TODO: 15/02/2024 "T2: créez un attribut  dto basic training avec ses accesseurs"
    private CompanyBasicDTO company;

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

}
