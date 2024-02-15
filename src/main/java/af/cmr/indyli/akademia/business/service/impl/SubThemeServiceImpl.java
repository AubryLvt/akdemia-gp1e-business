package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.SubThemeRepository;
import af.cmr.indyli.akademia.business.dto.basic.SubThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.SubThemeFullDTO;
import af.cmr.indyli.akademia.business.entity.SubTheme;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.ISubThemeService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.SUB_THEME_SERVICE_KEY)
public class SubThemeServiceImpl extends AbstractAkdemiaServiceImpl<SubTheme, SubThemeBasicDTO, SubThemeFullDTO, SubThemeRepository> implements ISubThemeService {

    @Resource(name = ConstsValues.ConstsDAO.SUB_THEME_DAO_KEY)
    private SubThemeRepository subThemeRepository;

    public SubThemeServiceImpl() {
        super(SubTheme.class, SubThemeBasicDTO.class, SubThemeFullDTO.class);
    }

    @Override
    public SubThemeRepository getDAO() {
        return this.subThemeRepository;
    }

    @Override
    public SubThemeFullDTO create(SubThemeFullDTO view) throws AkdemiaBusinessException {
        SubTheme subTheme = this.getDAO().findBySubthemeTitle(view.getSubthemeTitle());
        if (subTheme == null) {
            view.setCreationDate(new Date());
            SubTheme entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, SubTheme.class));
            view.setId(entity.getId());
            return view;
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG06);
    }

    @Override
    public SubThemeFullDTO update(SubThemeFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        boolean isSubThemeExist = this.findAll().stream().anyMatch(p -> viewToUpdate.getSubthemeTitle().equals(p.getSubthemeTitle()) && !viewToUpdate.getId().equals(p.getId()));

        if (!isSubThemeExist) {
            viewToUpdate.setUpdateDate(new Date());
            SubTheme entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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
       var tmpTrainings = this.findById(id);

       if (tmpTrainings == null){
           throw new AkdemiaBusinessException("L'élement à supprimer n'existe pas");
       }

       // TODO: 15/02/2024 "T11: ajoutez un bloc if pour gérer la RG11"

       this.getDAO().deleteById(id);

    }
}