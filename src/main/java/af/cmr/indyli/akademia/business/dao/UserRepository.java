package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.User;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = ConstsValues.ConstsDAO.USER_DAO_KEY)
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);
}
