package af.cmr.indyli.akademia.business.dto.medium;

import af.cmr.indyli.akademia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akademia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akademia.business.entity.Role;
import af.cmr.indyli.akademia.business.entity.User;
import jakarta.persistence.ManyToOne;

public class PrivilegeMediumDTO extends PrivilegeBasicDTO {
    private UserBasicDTO user;
    private RoleBasicDTO role;


    public UserBasicDTO getUser() {
        return user;
    }

    public void setUser(UserBasicDTO user) {
        this.user = user;
    }


    public RoleBasicDTO getRole() {
        return role;
    }

    public void setRole(RoleBasicDTO role) {
        this.role = role;
    }
}

