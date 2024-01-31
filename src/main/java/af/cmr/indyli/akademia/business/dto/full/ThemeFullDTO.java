package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.SubThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.ThemeMediumDTO;
import af.cmr.indyli.akademia.business.entity.SubTheme;

import java.util.ArrayList;
import java.util.List;

public class ThemeFullDTO extends ThemeMediumDTO {
    private List<SubThemeBasicDTO> subThemes = new ArrayList<>();

    public List<SubThemeBasicDTO> getSubThemes() {
        return subThemes;
    }

    public void setSubThemes(List<SubThemeBasicDTO> subThemes) {
        this.subThemes = subThemes;
    }
}