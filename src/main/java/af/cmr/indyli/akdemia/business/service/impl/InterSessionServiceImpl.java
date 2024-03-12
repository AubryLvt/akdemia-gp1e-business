package af.cmr.indyli.akdemia.business.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IInterSessionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@Service(ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
public class InterSessionServiceImpl
	extends AbstractAkdemiaServiceImpl<InterSession, InterSessionBasicDTO, InterSessionFullDTO, IInterSessionRepository>
	implements IInterSessionService{
	
	@Resource(name = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
	private IInterSessionRepository interSessionRepository;

	
	public InterSessionServiceImpl() {
		super(InterSession.class, InterSessionBasicDTO.class, InterSessionFullDTO.class);
	}


	@Override
	public IInterSessionRepository getDAO() {
		// TODO Auto-generated method stub
		return this.interSessionRepository;
	}

}
