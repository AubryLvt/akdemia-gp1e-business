package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.TestBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.ValidationTestBasicDTO;
import af.cmr.indyli.akademia.business.entity.Test;
import af.cmr.indyli.akademia.business.entity.Training;

public class ValidationTestMediumDTO extends ValidationTestBasicDTO {
    private TrainingBasicDTO training;
    private TestBasicDTO test;

    public ValidationTestMediumDTO() {
    }
}