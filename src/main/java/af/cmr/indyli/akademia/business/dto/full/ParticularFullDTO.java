package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.ParticularMediumDTO;

import java.util.ArrayList;
import java.util.List;

public class ParticularFullDTO extends ParticularMediumDTO {

    private List<ParticularSubscriptionBasicDTO> particularSubscriptions = new ArrayList<>();

    public ParticularFullDTO() {
    }

    public List<ParticularSubscriptionBasicDTO> getParticularSubscriptions() {
        return particularSubscriptions;
    }

    public void setParticularSubscriptions(List<ParticularSubscriptionBasicDTO> particularSubscriptions) {
        this.particularSubscriptions = particularSubscriptions;
    }
}
