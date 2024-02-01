package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;

public class EmployeeMediumDTO extends EmployeeBasicDTO {
    private CompanyBasicDTO company;

    public EmployeeMediumDTO() {
    }

    public CompanyBasicDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyBasicDTO company) {
        this.company = company;
    }
}
