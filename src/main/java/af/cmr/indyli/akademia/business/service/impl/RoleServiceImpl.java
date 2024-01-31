package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.RoleRepository;
import af.cmr.indyli.akademia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.RoleFullDTO;
import af.cmr.indyli.akademia.business.entity.Role;
import af.cmr.indyli.akademia.business.service.IRoleService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.ROLE_SERVICE_KEY)
public class RoleServiceImpl extends AbstractAkdemiaServiceImpl<Role, RoleBasicDTO, RoleFullDTO, RoleRepository> implements IRoleService {


    @Resource(name = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
    private RoleRepository roleRepository;

    public RoleServiceImpl() {
        super(Role.class, RoleBasicDTO.class, RoleFullDTO.class);
    }

    @Override
    public RoleRepository getDAO() {
        return this.roleRepository;
    }
}