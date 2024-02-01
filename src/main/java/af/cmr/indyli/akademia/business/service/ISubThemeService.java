package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.SubThemeRepository;
import af.cmr.indyli.akademia.business.dto.basic.SubThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.SubThemeFullDTO;
import af.cmr.indyli.akademia.business.entity.SubTheme;

public interface ISubThemeService extends IAbstractAkdemiaService<SubTheme, SubThemeBasicDTO, SubThemeFullDTO, SubThemeRepository> {

}