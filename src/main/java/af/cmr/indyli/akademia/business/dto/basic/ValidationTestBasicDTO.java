package af.cmr.indyli.akademia.business.dto.basic;

import af.cmr.indyli.akademia.business.dto.IDTO;
import af.cmr.indyli.akademia.business.entity.Test;
import af.cmr.indyli.akademia.business.entity.Training;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ValidationTestBasicDTO implements IDTO {
    private Integer id;
    private Date testDate;
    private Integer score;
    private Date creationDate;
    private Date updateDate;
    public ValidationTestBasicDTO() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
