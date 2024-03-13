package af.cmr.indyli.akdemia.business.dto.basic;

import java.util.Date;

import af.cmr.indyli.akdemia.business.dto.IDTO;

public class IntraSessionBasicDTO implements IDTO {
	
	private static final long serialVersionUID = -7953962057286309818L;
	private Integer id;
	private String code;
	private Double duration;
	private Double price;
	private String description;
	private String status;
	private Date date;
	private String location;
	private Date creationDate;
	private Date updateDate;
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	@Override
	public Date getCreationDate() {
		return date;
	}
	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public Date getUpdateDate() {
		return updateDate;
	}
	@Override
	public void setUpdateDate(Date creationDate) {
		this.updateDate = creationDate;
	}

}
