package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.EmployeeMediumDTO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFullDTO extends EmployeeMediumDTO {

    private List<EmployeeSubscriptionBasicDTO> employeeSubscriptions = new ArrayList<>();

    public EmployeeFullDTO() {
    }

    public List<EmployeeSubscriptionBasicDTO> getEmployeeSubscriptions() {
        return employeeSubscriptions;
    }

    public void setEmployeeSubscriptions(List<EmployeeSubscriptionBasicDTO> employeeSubscriptions) {
        this.employeeSubscriptions = employeeSubscriptions;
    }
}
