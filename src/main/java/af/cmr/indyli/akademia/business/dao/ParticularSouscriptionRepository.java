package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.InterSession;
import af.cmr.indyli.akademia.business.entity.ParticularSubscription;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = ConstsValues.ConstsDAO.PARTICULAR_SOUSCRIPTION_DAO_KEY)
public interface ParticularSouscriptionRepository extends JpaRepository<ParticularSubscription, Integer> {

    List<ParticularSubscription> findByInterSession(InterSession interSession);
}