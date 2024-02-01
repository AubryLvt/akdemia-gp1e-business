package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.Theme;
import af.cmr.indyli.akademia.business.entity.Training;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.TRAINING_DAO_KEY)
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    Training findByTitle(String title);
}
