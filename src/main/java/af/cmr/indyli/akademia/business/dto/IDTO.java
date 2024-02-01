package af.cmr.indyli.akademia.business.dto;

import java.io.Serializable;
import java.util.Date;

public interface IDTO extends Serializable {
    public Integer getId();

    public void setId(Integer id);

    public Date getCreationDate();

    public void setCreationDate(Date creationDate);

    public Date getUpdateDate();

    public void setUpdateDate(Date creationDate);
}
