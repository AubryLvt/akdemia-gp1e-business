package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Requirement;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.REQUIREMENT_DAO_KEY)
public interface RequirementRepository extends JpaRepository<Requirement, Integer> {
}
