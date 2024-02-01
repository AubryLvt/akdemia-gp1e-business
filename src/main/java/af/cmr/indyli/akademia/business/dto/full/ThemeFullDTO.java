package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.medium.ThemeMediumDTO;
import af.cmr.indyli.akademia.business.entity.SubTheme;

import java.util.ArrayList;
import java.util.List;

public class ThemeFullDTO extends ThemeMediumDTO {
    private List<SubTheme> subThemes = new ArrayList<>();

    public List<SubTheme> getSubThemes() {
        return subThemes;
    }

    public void setSubThemes(List<SubTheme> subThemes) {
        this.subThemes = subThemes;
    }
}