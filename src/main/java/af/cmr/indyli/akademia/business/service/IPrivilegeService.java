package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.PrivilegeRepository;
import af.cmr.indyli.akademia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.PrivilegeFullDTO;
import af.cmr.indyli.akademia.business.entity.Privilege;

public interface IPrivilegeService extends IAbstractAkdemiaService<Privilege, PrivilegeBasicDTO, PrivilegeFullDTO, PrivilegeRepository> {
}