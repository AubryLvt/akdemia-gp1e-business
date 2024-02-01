package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.UserRepository;
import af.cmr.indyli.akademia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.UserFullDTO;
import af.cmr.indyli.akademia.business.entity.User;

public interface IUserService extends IAbstractAkdemiaService<User, UserBasicDTO, UserFullDTO, UserRepository> {
    boolean isExistUserByEmail(String email);

    boolean isExistUserByEmail(String email, Integer id);
}