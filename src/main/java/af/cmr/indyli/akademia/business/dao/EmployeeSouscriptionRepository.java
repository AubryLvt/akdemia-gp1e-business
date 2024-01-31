package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.EMPLOYEE_SOUSCRIPTION_DAO_KEY)
public interface EmployeeSouscriptionRepository extends JpaRepository<EmployeeSubscription, Integer> {
}
