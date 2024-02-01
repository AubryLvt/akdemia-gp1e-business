package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.PlanificationRepository;
import af.cmr.indyli.akademia.business.dto.basic.PlanificationBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.PlanificationFullDTO;
import af.cmr.indyli.akademia.business.entity.Planification;
import af.cmr.indyli.akademia.business.service.IPlanificationService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.PLANIFICATION_SERVICE_KEY)
public class PlanificationServiceImpl extends AbstractAkdemiaServiceImpl<Planification, PlanificationBasicDTO, PlanificationFullDTO, PlanificationRepository> implements IPlanificationService {

    @Resource(name = ConstsValues.ConstsDAO.PLANIFICATION_DAO_KEY)
    private PlanificationRepository planificationRepository;

    public PlanificationServiceImpl() {
        super(Planification.class, PlanificationBasicDTO.class, PlanificationFullDTO.class);
    }

    @Override
    public PlanificationRepository getDAO() {
        return this.planificationRepository;
    }
}
