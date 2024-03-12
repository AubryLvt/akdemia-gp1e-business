package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.Session;

public interface ISessionService extends IAbstractAkdemiaService<Session, SessionBasicDTO, SessionFullDTO, ISessionRepository>{

}
