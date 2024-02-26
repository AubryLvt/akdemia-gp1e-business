package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IUserRepository;
import af.cmr.indyli.akademia.business.dto.UserRegistrationDTO;
import af.cmr.indyli.akademia.business.dto.UserRegistrationResponseDTO;
import af.cmr.indyli.akademia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.UserFullDTO;
import af.cmr.indyli.akademia.business.entity.User;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user,
 * providing specific operations for {@link User} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IUserService
		extends IAbstractAkdemiaService<User, UserBasicDTO, UserFullDTO, IUserRepository>, UserDetailsService {
	boolean isExistUserByEmail(String email);

	boolean isExistUserByEmail(String email, Integer id);

	UserFullDTO findUserByEmail(String email);

	UserRegistrationResponseDTO registerUser(UserRegistrationDTO dto) throws AkdemiaBusinessException;
}