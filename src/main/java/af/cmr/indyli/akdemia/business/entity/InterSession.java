package af.cmr.indyli.akdemia.business.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "akdemia_inter_session")
public class InterSession extends Session {
// AJOUT SERIAL ID
    @Column(name = "MIN_PARTICIPANTS")
    private int minParticipants;

    // Constructeur par défaut
    public InterSession() {
    }

    // Constructeur avec paramètres
    public InterSession(int minParticipants /* autres paramètres hérités de Session */) {
        super();/* passer les paramètres hérités à travers le constructeur de la classe parente */
        this.minParticipants = minParticipants;
    }

   //  Getters et Setters
    @OneToOne
    @JoinColumn(name = "ID_AKDEMIA_PARTICULAR_SOUSCRIPTION", referencedColumnName 
    = "ID", insertable = false, updatable = false)
    private ParticularSubscription particularSubscription;
    
    public int getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(int minParticipants) {
        this.minParticipants = minParticipants;
    }
}