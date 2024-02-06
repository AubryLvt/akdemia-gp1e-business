package af.cmr.indyli.akademia.business.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "AKDEMIA_COMPANY")
public class Company extends User implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ACTIVITY")
    private String activity;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<IntraSession> intraSessions = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivity() {
        return this.activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<IntraSession> getIntraSessions() {
        return intraSessions;
    }

    public void setIntraSessions(List<IntraSession> intraSessions) {
        this.intraSessions = intraSessions;
    }
}