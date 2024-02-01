package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Privilege;
import af.cmr.indyli.akademia.business.entity.Role;
import af.cmr.indyli.akademia.business.entity.User;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
    List<Privilege> findByRole(Role role);

    List<Privilege> findByUser(User user);
}
