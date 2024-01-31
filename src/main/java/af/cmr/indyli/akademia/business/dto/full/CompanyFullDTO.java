package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.CompanyMediumDTO;
import af.cmr.indyli.akademia.business.entity.IntraSession;

import java.util.ArrayList;
import java.util.List;

public class CompanyFullDTO extends CompanyMediumDTO {
    private List<EmployeeBasicDTO> employees = new ArrayList<>();

    private List<IntraSessionBasicDTO> intraSessions = new ArrayList<>();

    public CompanyFullDTO() {
    }

    public List<EmployeeBasicDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBasicDTO> employees) {
        this.employees = employees;
    }

    public List<IntraSessionBasicDTO> getIntraSessions() {
        return intraSessions;
    }

    public void setIntraSessions(List<IntraSessionBasicDTO> intraSessions) {
        this.intraSessions = intraSessions;
    }
}
