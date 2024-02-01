package af.cmr.indyli.akademia.business.dto.basic;

import af.cmr.indyli.akademia.business.dto.IDTO;

import java.io.Serializable;
import java.util.Date;

public class TrainingBasicDTO implements IDTO {
    private Integer id;
    private String title;
    private String description;
    private Double trainingPrice;
    private String logo;
    private Date creationDate;
    private Date updateDate;

    public TrainingBasicDTO() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTrainingPrice() {
        return trainingPrice;
    }

    public void setTrainingPrice(Double trainingPrice) {
        this.trainingPrice = trainingPrice;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
