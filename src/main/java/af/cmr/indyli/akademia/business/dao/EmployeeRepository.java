package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Company;
import af.cmr.indyli.akademia.business.entity.Employee;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.EMPLOYEE_DAO_KEY)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findByCompany(Company company);
}