package af.cmr.indyli.akademia.business.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AKDEMIA_PARTICULAR")
public class Particular extends User {

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "GENDER")
    private String gender;
    @Column(name = "ACTIVITY")
    private String activity;

    @Column(name = "HIGHEST_DIPLOMA")
    private String highestDiploma;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @OneToMany(mappedBy = "particular", fetch = FetchType.EAGER)
    private List<ParticularSubscription> particularSubscriptions = new ArrayList<>();

    public Particular() {
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

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public List<ParticularSubscription> getParticularSubscriptions() {
        return particularSubscriptions;
    }

    public void setParticularSubscriptions(List<ParticularSubscription> particularSubscriptions) {
        this.particularSubscriptions = particularSubscriptions;
    }

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
}