package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.ManagerRepository;
import af.cmr.indyli.akademia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ManagerFullDTO;
import af.cmr.indyli.akademia.business.entity.Manager;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

import java.util.List;

public interface IManagerService extends IAbstractAkdemiaService<Manager, ManagerBasicDTO, ManagerFullDTO, ManagerRepository> {

}
