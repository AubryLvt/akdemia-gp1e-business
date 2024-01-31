package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.RequirementRepository;
import af.cmr.indyli.akademia.business.dto.basic.RequirementBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.RequirementFullDTO;
import af.cmr.indyli.akademia.business.entity.Requirement;

public interface IRequirementService extends IAbstractAkdemiaService<Requirement, RequirementBasicDTO, RequirementFullDTO, RequirementRepository> {
}