package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.InterSessionMediumDTO;

import java.util.List;

public class InterSessionFullDTO extends InterSessionMediumDTO {

    private List<ParticularSubscriptionFullDTO> particularSubscriptions;

    public InterSessionFullDTO() {
    }

    public List<ParticularSubscriptionFullDTO> getParticularSubscriptions() {
        return particularSubscriptions;
    }

    public void setParticularSubscriptions(List<ParticularSubscriptionFullDTO> particularSubscriptions) {
        this.particularSubscriptions = particularSubscriptions;
    }
}
