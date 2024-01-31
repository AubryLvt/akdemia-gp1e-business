package af.cmr.indyli.akademia.business.service.impl;


import af.cmr.indyli.akademia.business.dao.EvaluationRepository;
import af.cmr.indyli.akademia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EvaluationFullDTO;
import af.cmr.indyli.akademia.business.entity.Evaluation;
import af.cmr.indyli.akademia.business.service.IEvaluationService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.EVALUATION_SERVICE_KEY)
public class EvaluationServiceImpl extends AbstractAkdemiaServiceImpl<Evaluation, EvaluationBasicDTO, EvaluationFullDTO, EvaluationRepository> implements IEvaluationService {

    @Resource(name = ConstsValues.ConstsDAO.EVALUATION_DAO_KEY)
    private EvaluationRepository evaluationRepository;

    public EvaluationServiceImpl() {
        super(Evaluation.class, EvaluationBasicDTO.class, EvaluationFullDTO.class);
    }

    @Override
    public EvaluationRepository getDAO() {
        return this.evaluationRepository;
    }


}
