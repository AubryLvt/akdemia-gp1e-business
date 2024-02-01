package af.cmr.indyli.akademia.business.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AKDEMIA_INTRA_SESSION")
public class IntraSession extends Session {

    @OneToMany(mappedBy = "intraSession", fetch = FetchType.EAGER)
    private List<EmployeeSubscription> employeeSubscriptions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ID_AKDEMIA_COMPANY")
    private Company company;

    public List<EmployeeSubscription> getEmployeeSubscriptions() {
        return employeeSubscriptions;
    }

    public void setEmployeeSubscriptions(List<EmployeeSubscription> employeeSubscriptions) {
        this.employeeSubscriptions = employeeSubscriptions;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
