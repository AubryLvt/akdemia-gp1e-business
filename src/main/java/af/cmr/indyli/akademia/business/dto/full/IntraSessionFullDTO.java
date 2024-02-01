package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.IntraSessionMediumDTO;

import java.util.List;

public class IntraSessionFullDTO extends IntraSessionMediumDTO {


    private List<EmployeeSubscriptionFullDTO> employeeSubscriptions;

    public IntraSessionFullDTO() {
    }

    public List<EmployeeSubscriptionFullDTO> getEmployeeSubscriptions() {
        return employeeSubscriptions;
    }

    public void setEmployeeSubscriptions(List<EmployeeSubscriptionFullDTO> employeeSubscriptions) {
        this.employeeSubscriptions = employeeSubscriptions;
    }
}
