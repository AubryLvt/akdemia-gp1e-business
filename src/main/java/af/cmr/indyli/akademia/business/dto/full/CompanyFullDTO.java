package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.CompanyMediumDTO;

import java.util.ArrayList;
import java.util.List;

public class CompanyFullDTO extends CompanyMediumDTO {
    private List<EmployeeBasicDTO> employees = new ArrayList<>();

    // TODO: 15/02/2024 "T4: creez un attribut  dto List<basic> intrasessions avec ses accesseurs"

    public CompanyFullDTO() {
    }

    public List<EmployeeBasicDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBasicDTO> employees) {
        this.employees = employees;
    }
}
