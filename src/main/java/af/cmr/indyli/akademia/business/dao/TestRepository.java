package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Test;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.TEST_DAO_KEY)
public interface TestRepository extends JpaRepository<Test, Integer> {
}