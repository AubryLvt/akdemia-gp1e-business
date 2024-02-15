package af.cmr.indyli.akademia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akademia.business.dto.basic.ThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.SubThemeMediumDTO;

public class SubThemeFullDTO extends SubThemeMediumDTO {
    // TODO: 15/02/2024 "T7: créez un attribut  dto List<basic> trainings avec ses accesseurs"

    private List<ThemeBasicDTO> themes = new ArrayList<>();

    public List<ThemeBasicDTO> getThemes() {
        return themes;
    }

    public void setThemes(List<ThemeBasicDTO> themes) {
        this.themes = themes;
    }
}