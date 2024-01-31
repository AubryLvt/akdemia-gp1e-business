package af.cmr.indyli.akademia.business.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "AKDEMIA_EMPLOYEE_SOUSCRIPTION")
public class EmployeeSubscription implements IEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AKDEMIA_INTRA_SESSION")
    private IntraSession intraSession;
    @ManyToOne
    @JoinColumn(name = "ID_AKDEMIA_EMPLOYEE")
    private Employee employee;

    public EmployeeSubscription() {
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public IntraSession getIntraSession() {
        return intraSession;
    }

    public void setIntraSession(IntraSession intraSession) {
        this.intraSession = intraSession;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
