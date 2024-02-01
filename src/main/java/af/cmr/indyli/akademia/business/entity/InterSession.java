package af.cmr.indyli.akademia.business.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AKDEMIA_INTER_SESSION")
public class InterSession extends Session {

    @Column(name = " MIN_PARTICIPANTS")
    private Integer minParticipants;

    @OneToMany(mappedBy = "interSession", fetch = FetchType.EAGER)
    private List<ParticularSubscription> particularSubscriptions;

    public Integer getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(Integer minParticipants) {
        this.minParticipants = minParticipants;
    }

    public List<ParticularSubscription> getParticularSubscriptions() {
        return particularSubscriptions;
    }

    public void setParticularSubscriptions(List<ParticularSubscription> particularSubscriptions) {
        this.particularSubscriptions = particularSubscriptions;
    }
}
