package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Particular;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.PARTICULAR_DAO_KEY)
public interface ParticularRepository extends JpaRepository<Particular, Integer> {
}