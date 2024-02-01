package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.UserRepository;
import af.cmr.indyli.akademia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.UserFullDTO;
import af.cmr.indyli.akademia.business.entity.User;
import af.cmr.indyli.akademia.business.service.IUserService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.USER_SERVICE_KEY)
public class UserServiceImpl extends AbstractAkdemiaServiceImpl<User, UserBasicDTO, UserFullDTO, UserRepository> implements IUserService {
    @Resource(name = ConstsValues.ConstsDAO.USER_DAO_KEY)
    private UserRepository userRepository;

    public UserServiceImpl() {
        super(User.class, UserBasicDTO.class, UserFullDTO.class);

    }

    @Override
    public UserRepository getDAO() {
        return this.userRepository;
    }

    @Override
    public boolean isExistUserByEmail(String email) {
        if (email == null) {
            return false;
        }
        return this.findAll().stream().anyMatch(u -> email.equals(u.getEmail()));
    }

    @Override
    public boolean isExistUserByEmail(String email, Integer id) {
        if (email == null || id == null) {
            return false;
        }

        return this.findAll().stream().anyMatch(u -> email.equals(u.getEmail()) && !id.equals(u.getId()));
    }
}
