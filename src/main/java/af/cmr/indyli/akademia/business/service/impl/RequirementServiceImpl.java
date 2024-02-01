package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.RequirementRepository;
import af.cmr.indyli.akademia.business.dto.basic.RequirementBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.RequirementFullDTO;
import af.cmr.indyli.akademia.business.entity.Requirement;
import af.cmr.indyli.akademia.business.service.IRequirementService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.REQUIREMENT_SERVICE_KEY)
public class RequirementServiceImpl extends AbstractAkdemiaServiceImpl<Requirement, RequirementBasicDTO, RequirementFullDTO, RequirementRepository> implements IRequirementService {

    @Resource(name = ConstsValues.ConstsDAO.REQUIREMENT_DAO_KEY)
    private RequirementRepository requirementRepository;

    public RequirementServiceImpl() {
        super(Requirement.class, RequirementBasicDTO.class, RequirementFullDTO.class);
    }

    @Override
    public RequirementRepository getDAO() {
        return this.requirementRepository;
    }
}