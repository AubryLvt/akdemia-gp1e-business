package af.cmr.indyli.akademia.business.dto.basic;

import af.cmr.indyli.akademia.business.dto.IDTO;

import java.util.Date;

public class PlanificationBasicDTO implements IDTO {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Date creationDate;
    private Date updateDate;

    public PlanificationBasicDTO() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
