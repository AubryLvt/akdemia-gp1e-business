package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IManagerRepository;
import af.cmr.indyli.akademia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ManagerFullDTO;
import af.cmr.indyli.akademia.business.entity.Manager;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * manager, providing specific operations for {@link Manager} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IManagerService
		extends IAbstractAkdemiaService<Manager, ManagerBasicDTO, ManagerFullDTO, IManagerRepository> {

}
