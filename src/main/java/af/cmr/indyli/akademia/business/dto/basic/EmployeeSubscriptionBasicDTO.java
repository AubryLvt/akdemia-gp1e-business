package af.cmr.indyli.akademia.business.dto.basic;

import af.cmr.indyli.akademia.business.dto.IDTO;
import af.cmr.indyli.akademia.business.entity.Status;

import java.util.Date;

public class EmployeeSubscriptionBasicDTO implements IDTO {
    private Integer id;
    private Status status;
    private Date creationDate;
    private Date updateDate;

    public EmployeeSubscriptionBasicDTO() {
        super();
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
