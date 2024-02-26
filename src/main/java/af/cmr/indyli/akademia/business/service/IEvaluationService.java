package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IEvaluationRepository;
import af.cmr.indyli.akademia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EvaluationFullDTO;
import af.cmr.indyli.akademia.business.entity.Evaluation;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * Evaluation, providing specific operations for {@link Evaluation} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IEvaluationService
		extends IAbstractAkdemiaService<Evaluation, EvaluationBasicDTO, EvaluationFullDTO, IEvaluationRepository> {

}
