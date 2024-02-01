package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.IntraSession;
import af.cmr.indyli.akademia.business.entity.Session;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
public interface IntraSessionRepository extends JpaRepository<IntraSession, Integer> {
    IntraSession findByCode(String code);
}