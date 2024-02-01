package af.cmr.indyli.akademia.business.dto.medium;

import java.util.Date;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akademia.business.entity.Employee;
import af.cmr.indyli.akademia.business.entity.Particular;
import af.cmr.indyli.akademia.business.entity.Session;

public class EvaluationMediumDTO extends EvaluationBasicDTO {
    private EmployeeBasicDTO employee;
    private SessionBasicDTO session;
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

    public SessionBasicDTO getSession() {
        return session;
    }

    public void setSession(SessionBasicDTO session) {
        this.session = session;
    }

    public ParticularBasicDTO getParticular() {
        return particular;
    }

    public void setParticular(ParticularBasicDTO particular) {
        this.particular = particular;
    }
}
