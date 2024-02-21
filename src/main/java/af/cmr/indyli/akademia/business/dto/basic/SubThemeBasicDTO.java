package af.cmr.indyli.akademia.business.dto.basic;

import af.cmr.indyli.akademia.business.dto.IDTO;

import java.util.Date;

public class SubThemeBasicDTO implements IDTO {
    private Integer id;
    private String subthemeTitle;
    private String description;
    private Date creationDate;
    private Date updateDate;

    public SubThemeBasicDTO() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubthemeTitle() {
        return subthemeTitle;
    }

    public void setSubthemeTitle(String subthemeTitle) {
        this.subthemeTitle = subthemeTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
