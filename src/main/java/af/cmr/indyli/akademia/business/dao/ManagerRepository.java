package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Manager;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = ConstsValues.ConstsDAO.MANAGER_DAO_KEY)
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    Manager findByEmail(String email);
}