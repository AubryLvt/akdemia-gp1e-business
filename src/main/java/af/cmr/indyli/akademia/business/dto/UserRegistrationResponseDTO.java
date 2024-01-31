package af.cmr.indyli.akademia.business.dto;

public class UserRegistrationResponseDTO {

    private Integer id;
    private String email;

    public UserRegistrationResponseDTO() {
    }

    public UserRegistrationResponseDTO(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
