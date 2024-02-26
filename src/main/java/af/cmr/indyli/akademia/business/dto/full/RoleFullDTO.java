package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.RoleMediumDTO;
import af.cmr.indyli.akademia.business.entity.Role;

import java.util.List;

/**
 * This class represents a full Data Transfer Object (DTO) for a {@link Role}
 * entity, it extends {@link RoleMediumDTO}.
 */
public class RoleFullDTO extends RoleMediumDTO {

	public RoleFullDTO() {

	}

	private List<PrivilegeBasicDTO> privileges;

	public List<PrivilegeBasicDTO> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<PrivilegeBasicDTO> privileges) {
		this.privileges = privileges;
	}
}