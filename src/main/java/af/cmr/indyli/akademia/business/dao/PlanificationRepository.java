package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Planification;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.PLANIFICATION_DAO_KEY)
public interface PlanificationRepository extends JpaRepository<Planification, Integer> {
}
