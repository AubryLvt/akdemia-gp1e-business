package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.SessionMediumDTO;

public class SessionFullDTO extends SessionMediumDTO{

	private static final long serialVersionUID = 7312366509981349653L;

	private List<SessionBasicDTO> sessions = new ArrayList<>();


	public SessionFullDTO() {
	}

	public List<SessionBasicDTO> getSessions() {
		return sessions;
	}

	public void setSessions(List<SessionBasicDTO> sessions) {
		this.sessions = sessions;
	}

}
