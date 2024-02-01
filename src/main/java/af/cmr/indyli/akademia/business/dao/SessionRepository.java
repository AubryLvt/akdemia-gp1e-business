package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Session;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.SESSION_DAO_KEY)
public interface SessionRepository extends JpaRepository<Session, Integer> {
    public Session findByCode(String code);
}
