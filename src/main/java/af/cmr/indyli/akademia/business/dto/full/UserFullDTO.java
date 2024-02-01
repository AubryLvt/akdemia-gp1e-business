package af.cmr.indyli.akademia.business.dto.full;

import af.cmr.indyli.akademia.business.dto.medium.UserMediumDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class UserFullDTO extends UserMediumDTO {
    public UserFullDTO() {
    }

    @JsonIgnore
    private List<PrivilegeFullDTO> privileges;

    public List<PrivilegeFullDTO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeFullDTO> privileges) {
        this.privileges = privileges;
    }
}