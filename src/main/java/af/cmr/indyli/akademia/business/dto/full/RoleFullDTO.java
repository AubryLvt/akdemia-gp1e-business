package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akademia.business.dto.medium.RoleMediumDTO;
import af.cmr.indyli.akademia.business.entity.Privilege;

import java.util.List;

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