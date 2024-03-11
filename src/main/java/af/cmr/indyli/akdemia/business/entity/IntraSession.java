package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "akdemia_intra_session")
public class IntraSession extends Session{
	
	// serial Id à ajouter
    
	// Constructeur par défaut
    public IntraSession() {
        super(); // Appel du constructeur de la classe parente
    }
    
	 @ManyToOne
	 @JoinColumn(name = "ID_AKDEMIA_COMPANY", referencedColumnName 
	 = "ID", insertable = false, updatable = false)
	  private Company company;
	    
	    

}
