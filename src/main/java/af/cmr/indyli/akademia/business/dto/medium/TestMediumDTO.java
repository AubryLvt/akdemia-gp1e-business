package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.TestBasicDTO;
import af.cmr.indyli.akademia.business.entity.Test;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link Test}
 * entity. It extends {@link TestBasicDTO} and inherits basic information about
 * a test. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class TestMediumDTO extends TestBasicDTO {
	public TestMediumDTO() {
	}
}