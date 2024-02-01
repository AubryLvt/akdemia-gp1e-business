package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.EvaluationRepository;
import af.cmr.indyli.akademia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EvaluationFullDTO;
import af.cmr.indyli.akademia.business.entity.Evaluation;


public interface IEvaluationService extends IAbstractAkdemiaService<Evaluation, EvaluationBasicDTO, EvaluationFullDTO, EvaluationRepository> {

}
