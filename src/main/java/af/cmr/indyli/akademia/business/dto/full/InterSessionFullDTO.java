package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.InterSessionMediumDTO;
import af.cmr.indyli.akademia.business.dto.medium.ParticularSubscriptionMediumDTO;

import java.util.List;

public class InterSessionFullDTO extends InterSessionMediumDTO {

    private List<ParticularSubscriptionMediumDTO> particularSubscriptions;

    public InterSessionFullDTO() {
    }

    public List<ParticularSubscriptionMediumDTO> getParticularSubscriptions() {
        return particularSubscriptions;
    }

    public void setParticularSubscriptions(List<ParticularSubscriptionMediumDTO> particularSubscriptions) {
        this.particularSubscriptions = particularSubscriptions;
    }
}
