package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.ValidationTest;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.VALIDATION_TEST_DAO_KEY)
public interface ValidationTestRepository extends JpaRepository<ValidationTest, Integer> {
}