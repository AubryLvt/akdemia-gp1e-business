package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IPrivilegeRepository;
import af.cmr.indyli.akademia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.PrivilegeFullDTO;
import af.cmr.indyli.akademia.business.entity.Privilege;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * privilege, providing specific operations for {@link Privilege} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IPrivilegeService
		extends IAbstractAkdemiaService<Privilege, PrivilegeBasicDTO, PrivilegeFullDTO, IPrivilegeRepository> {
}