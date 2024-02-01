package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Role;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}