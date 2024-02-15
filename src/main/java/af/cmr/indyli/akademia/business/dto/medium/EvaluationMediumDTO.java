package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.ParticularBasicDTO;

public class EvaluationMediumDTO extends EvaluationBasicDTO {

    // TODO: 15/02/2024 "T1: créez un attribut  dto basic session avec ses accesseurs"

    private EmployeeBasicDTO employee;
    private ParticularBasicDTO particular;

    public EvaluationMediumDTO() {
        super();
    }

    public EmployeeBasicDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBasicDTO employee) {
        this.employee = employee;
    }
    

    public ParticularBasicDTO getParticular() {
        return particular;
    }

    public void setParticular(ParticularBasicDTO particular) {
        this.particular = particular;
    }
}
