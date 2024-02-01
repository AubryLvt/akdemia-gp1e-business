package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.InterSession;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
public interface InterSessionRepository extends JpaRepository<InterSession, Integer> {
    InterSession findByCode(String code);
}
