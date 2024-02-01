package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.TrainerMediumDTO;

import java.util.ArrayList;
import java.util.List;

public class TrainerFullDTO extends TrainerMediumDTO {
    private List<SessionBasicDTO> sessions = new ArrayList<>();

    public List<SessionBasicDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionBasicDTO> sessions) {
        this.sessions = sessions;
    }
}