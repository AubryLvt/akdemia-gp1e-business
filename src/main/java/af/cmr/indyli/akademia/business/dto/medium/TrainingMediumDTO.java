package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.RequirementBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.entity.Requirement;

public class TrainingMediumDTO extends TrainingBasicDTO {
    private RequirementBasicDTO requirement;
    public TrainingMediumDTO() {
    }

    public RequirementBasicDTO getRequirement() {
        return requirement;
    }

    public void setRequirement(RequirementBasicDTO requirement) {
        this.requirement = requirement;
    }
}