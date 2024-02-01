package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.ThemeRepository;
import af.cmr.indyli.akademia.business.dto.basic.ThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ThemeFullDTO;
import af.cmr.indyli.akademia.business.entity.Theme;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

import java.nio.file.AccessDeniedException;

public interface IThemeService extends IAbstractAkdemiaService<Theme, ThemeBasicDTO, ThemeFullDTO, ThemeRepository> {

}