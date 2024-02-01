package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;

public class ParticularSubscriptionMediumDTO extends ParticularSubscriptionBasicDTO {

    private ParticularBasicDTO particular;
    private InterSessionBasicDTO interSession;


    public ParticularSubscriptionMediumDTO() {
        super();
    }

    public ParticularBasicDTO getParticular() {
        return particular;
    }

    public void setParticular(ParticularBasicDTO particular) {
        this.particular = particular;
    }

    public InterSessionBasicDTO getInterSession() {
        return interSession;
    }

    public void setInterSession(InterSessionBasicDTO interSession) {
        this.interSession = interSession;
    }
}
