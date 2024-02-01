package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.InterSessionMediumDTO;

import java.util.List;

public class InterSessionFullDTO extends InterSessionMediumDTO {

    private List<ParticularSubscriptionBasicDTO> particularSubscriptions;

    public InterSessionFullDTO() {
    }

    public List<ParticularSubscriptionBasicDTO> getParticularSubscriptions() {
        return particularSubscriptions;
    }

    public void setParticularSubscriptions(List<ParticularSubscriptionBasicDTO> particularSubscriptions) {
        this.particularSubscriptions = particularSubscriptions;
    }
}
