package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.ThemeRepository;
import af.cmr.indyli.akademia.business.dto.basic.ThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ThemeFullDTO;
import af.cmr.indyli.akademia.business.entity.Theme;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IThemeService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.THEME_SERVICE_KEY)
public class ThemeServiceImpl extends AbstractAkdemiaServiceImpl<Theme, ThemeBasicDTO, ThemeFullDTO, ThemeRepository> implements IThemeService {

    @Resource(name = ConstsValues.ConstsDAO.THEME_DAO_KEY)
    private ThemeRepository themeRepository;

    public ThemeServiceImpl() {
        super(Theme.class, ThemeBasicDTO.class, ThemeFullDTO.class);
    }

    @Override
    public ThemeRepository getDAO() {
        return this.themeRepository;
    }


    @Override
    public ThemeFullDTO create(ThemeFullDTO view) throws AkdemiaBusinessException {
        Theme theme = this.getDAO().findByThemeTitle(view.getThemeTitle());
        if (theme == null) {
            view.setCreationDate(new Date());
            Theme entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Theme.class));
            view.setId(entity.getId());
            return view;
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG05);
    }

    @Override
    public ThemeFullDTO update(ThemeFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        boolean isThemeExist = this.findAll().stream().anyMatch(p -> viewToUpdate.getThemeTitle().equals(p.getThemeTitle()) && !viewToUpdate.getId().equals(p.getId()));
        if (!isThemeExist) {
            viewToUpdate.setUpdateDate(new Date());
            Theme entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
            if (entity != null) {
                BeanUtils.copyProperties(viewToUpdate, entity);
                this.getDAO().saveAndFlush(entity);
            } else {
                throw new AkdemiaBusinessException("L'objet à modifier N'existe pas en Base...");
            }
            return viewToUpdate;
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG06);
    }

    @Override
    public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
        var tmpSubTheme = this.findById(id);

        if (tmpSubTheme == null) {
            throw new AkdemiaBusinessException("L'élement à supprimer n'existe pas");
        }

        if (tmpSubTheme.getSubThemes().isEmpty()) {
            this.getDAO().deleteById(id);
        } else {
            throw new AkdemiaBusinessException(ReglesGestion.RG15);
        }
    }
}