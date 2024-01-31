package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.SessionRepository;
import af.cmr.indyli.akademia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akademia.business.entity.Session;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

public interface ISessionService extends IAbstractAkdemiaService<Session, SessionBasicDTO, SessionFullDTO, SessionRepository>{

    public SessionBasicDTO cancelSession(SessionBasicDTO sessionBasicDTO) throws AkdemiaBusinessException;
}
