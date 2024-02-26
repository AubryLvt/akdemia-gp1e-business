package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IRoleRepository;
import af.cmr.indyli.akademia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.RoleFullDTO;
import af.cmr.indyli.akademia.business.entity.Role;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing role,
 * providing specific operations for {@link Role} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IRoleService extends IAbstractAkdemiaService<Role, RoleBasicDTO, RoleFullDTO, IRoleRepository> {
}