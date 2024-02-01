package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.SubThemeBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.TrainingMediumDTO;

import java.util.ArrayList;
import java.util.List;

public class TrainingFullDTO extends TrainingMediumDTO {
    private List<SubThemeBasicDTO> subThemes = new ArrayList<>();

    private List<SessionBasicDTO> sessions = new ArrayList<>();

    public List<SessionBasicDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionBasicDTO> sessions) {
        this.sessions = sessions;
    }

    public List<SubThemeBasicDTO> getSubThemes() {
        return subThemes;
    }

    public void setSubThemes(List<SubThemeBasicDTO> subThemes) {
        this.subThemes = subThemes;
    }
}