package af.cmr.indyli.akademia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import af.cmr.indyli.akademia.business.dto.basic.ThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.SubThemeMediumDTO;

public class SubThemeFullDTO extends SubThemeMediumDTO {
    private List<TrainingBasicDTO> trainings = new ArrayList<>();
   
   
    private List<ThemeBasicDTO> themes = new ArrayList<>();

    public List<TrainingBasicDTO> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<TrainingBasicDTO> trainings) {
        this.trainings = trainings;
    }

    public List<ThemeBasicDTO> getThemes() {
        return themes;
    }

    public void setThemes(List<ThemeBasicDTO> themes) {
        this.themes = themes;
    }
}