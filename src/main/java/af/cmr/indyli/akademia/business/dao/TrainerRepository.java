package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Trainer;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.TRAINER_DAO_KEY)
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}