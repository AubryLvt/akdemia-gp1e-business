package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.IntraSessionBasicDTO;

public class EmployeeSubscriptionMediumDTO extends EmployeeSubscriptionBasicDTO {
    private EmployeeBasicDTO employee;
    private IntraSessionBasicDTO intraSession;

    public EmployeeSubscriptionMediumDTO() {
        super();
    }

    public EmployeeBasicDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeBasicDTO employee) {
        this.employee = employee;
    }

    public IntraSessionBasicDTO getIntraSession() {
        return intraSession;
    }

    public void setIntraSession(IntraSessionBasicDTO intraSession) {
        this.intraSession = intraSession;
    }
}
