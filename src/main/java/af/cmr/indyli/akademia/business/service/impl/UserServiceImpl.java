package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.ManagerRepository;
import af.cmr.indyli.akademia.business.dao.PrivilegeRepository;
import af.cmr.indyli.akademia.business.dao.RoleRepository;
import af.cmr.indyli.akademia.business.dao.UserRepository;
import af.cmr.indyli.akademia.business.dto.UserRegistrationDTO;
import af.cmr.indyli.akademia.business.dto.UserRegistrationResponseDTO;
import af.cmr.indyli.akademia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.UserFullDTO;
import af.cmr.indyli.akademia.business.entity.Manager;
import af.cmr.indyli.akademia.business.entity.Privilege;
import af.cmr.indyli.akademia.business.entity.Role;
import af.cmr.indyli.akademia.business.entity.User;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IUserService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service(ConstsValues.ServiceKeys.USER_SERVICE_KEY)
public class UserServiceImpl extends AbstractAkdemiaServiceImpl<User, UserBasicDTO, UserFullDTO, UserRepository> implements IUserService, UserDetailsService {
    @Resource(name = ConstsValues.ConstsDAO.USER_DAO_KEY)
    private UserRepository userRepository;

    @Resource(name = "BCRYPT_ENCODER")
    private BCryptPasswordEncoder passwordEncoder;

    @Resource(name = ConstsValues.ConstsDAO.MANAGER_DAO_KEY)
    private ManagerRepository managerRepository;

    @Resource(name = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
    private RoleRepository roleRepository;

    @Resource(name = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
    private PrivilegeRepository privilegeRepository;

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

    @Override
    public UserRegistrationResponseDTO registerUser(UserRegistrationDTO dto) throws AkdemiaBusinessException {
        User user = new User();

        if (isExistUserByEmail(dto.getEmail())) {
            throw new AkdemiaBusinessException(ReglesGestion.RG02);
        }

        Role role = roleRepository.findByRoleName(dto.getRoleName());

        if (dto.getRoleName().equalsIgnoreCase("manager")) {
            Manager manager = this.getModelMapper().map(dto,Manager.class);
            manager.setCreationDate(new Date());
            manager.setPassword(passwordEncoder.encode(dto.getPassword()));
            user = managerRepository.save(manager);
        }
        user = this.getModelMapper().map(dto,User.class);
        user.setCreationDate(new Date());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = userRepository.save(user);

        Privilege privilege = new Privilege();
        privilege.setUser(user);
        privilege.setRole(role);
        privilege.setCreationDate(new Date());

        privilegeRepository.save(privilege);

        return new UserRegistrationResponseDTO(user.getId(), user.getEmail());
    }

    @Override
    public UserFullDTO findUserByEmail(String email) throws AkdemiaBusinessException {

        Optional<User> user = this.getDAO().findUserByEmail(email);
        if (user.isEmpty()) throw new AkdemiaBusinessException("Aucun utilisateur ne correspond a cet email");

        return this.getModelMapper().map(user, UserFullDTO.class);
    }

    @Override
    public UserFullDTO findUserById(Integer userId) throws AkdemiaBusinessException {
        Optional<User> user = this.getDAO().findById(userId);
        if (user.isEmpty()) throw new AkdemiaBusinessException("Aucun utilisateur ne correspond a cet identifiant");

        if (user.get() instanceof Manager)
            return this.getModelMapper().map(this.managerRepository.findById(userId), UserFullDTO.class);


        return this.getModelMapper().map(user, UserFullDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepository.findUserByEmail(username);
        return userDetail.map(User::cloneUser).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
}