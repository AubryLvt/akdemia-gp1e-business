package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.RoleRepository;
import af.cmr.indyli.akademia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.RoleFullDTO;
import af.cmr.indyli.akademia.business.entity.Role;

public interface IRoleService extends IAbstractAkdemiaService<Role, RoleBasicDTO, RoleFullDTO, RoleRepository> {
}