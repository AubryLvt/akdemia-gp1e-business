package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Evaluation;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.EVALUATION_DAO_KEY)
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
}