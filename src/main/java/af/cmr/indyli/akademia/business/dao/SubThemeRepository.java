package af.cmr.indyli.akademia.business.dao;

import af.cmr.indyli.akademia.business.entity.SubTheme;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = ConstsValues.ConstsDAO.SUB_THEME_DAO_KEY)
public interface SubThemeRepository extends JpaRepository<SubTheme, Integer> {
    SubTheme findBySubthemeTitle(String subthemeTitle);
}



