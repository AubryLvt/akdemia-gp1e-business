package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Company;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = ConstsValues.ConstsDAO.COMPANY_DAO_KEY)
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}


