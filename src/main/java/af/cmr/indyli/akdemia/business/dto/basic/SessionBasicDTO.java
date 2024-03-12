package af.cmr.indyli.akdemia.business.dto.basic;

import java.util.Date;

import af.cmr.indyli.akdemia.business.dto.IDTO;

public class SessionBasicDTO implements IDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4257941809342943658L;
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
	
	public SessionBasicDTO() {
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getUpdateDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUpdateDate(Date creationDate) {
		// TODO Auto-generated method stub
		
	}


}
