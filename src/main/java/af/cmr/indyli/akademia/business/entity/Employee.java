package af.cmr.indyli.akademia.business.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AKDEMIA_EMPLOYEE")
public class Employee extends User {

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "HIGHEST_DIPLOMA")
    private String highestDiploma;

    public String getHighestDiploma() {
        return highestDiploma;
    }

    public void setHighestDiploma(String highestDiploma) {
        this.highestDiploma = highestDiploma;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "ID_AKDEMIA_COMPANY")
    private Company company;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<EmployeeSubscription> employeeSubscriptions = new ArrayList<>();

    public Employee() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<EmployeeSubscription> getEmployeeSubscriptions() {
        return employeeSubscriptions;
    }

    public void setEmployeeSubscriptions(List<EmployeeSubscription> employeeSubscriptions) {
        this.employeeSubscriptions = employeeSubscriptions;
    }
}