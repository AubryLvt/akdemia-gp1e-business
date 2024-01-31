package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.InterSessionRepository;
import af.cmr.indyli.akademia.business.dao.IntraSessionRepository;
import af.cmr.indyli.akademia.business.dao.SessionRepository;
import af.cmr.indyli.akademia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akademia.business.entity.InterSession;
import af.cmr.indyli.akademia.business.entity.IntraSession;
import af.cmr.indyli.akademia.business.entity.Session;
import af.cmr.indyli.akademia.business.entity.Status;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.ISessionService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.SESSION_SERVICE_KEY)
public class SessionServiceImpl extends AbstractAkdemiaServiceImpl<Session, SessionBasicDTO, SessionFullDTO, SessionRepository> implements ISessionService {

    @Resource(name = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
    private InterSessionRepository interSessionRepository;

    @Resource(name = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
    private IntraSessionRepository intraSessionRepository;

    @Resource(name = ConstsValues.ConstsDAO.SESSION_DAO_KEY)
    private SessionRepository sessionRepository;

    public SessionServiceImpl() {
        super(Session.class, SessionBasicDTO.class, SessionFullDTO.class);
    }

    @Override
    public SessionBasicDTO cancelSession(SessionBasicDTO sessionBasicDTO) throws AkdemiaBusinessException {
        Date today = new Date();
        LocalDate todayLocalDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate sessionLocalDate = sessionBasicDTO.getDate();
        long difference = ChronoUnit.DAYS.between(todayLocalDate, sessionLocalDate);
        if (difference < 15) throw new AkdemiaBusinessException("La date de début est proche de moin de 15 jours");

        Session session = getModelMapper().map(sessionBasicDTO, Session.class);
        if (session instanceof InterSession) {
            InterSession interSession = interSessionRepository.findById(sessionBasicDTO.getId()).get();
            interSession.setStatus(Status.CANCELLED);
            return getModelMapper().map(interSessionRepository.save(interSession), SessionBasicDTO.class);
        } else if (session instanceof IntraSession) {
            IntraSession intraSession = intraSessionRepository.findById(sessionBasicDTO.getId()).get();
            intraSession.setStatus(Status.CANCELLED);
            return getModelMapper().map(intraSessionRepository.save(intraSession), SessionBasicDTO.class);
        }
        throw new AkdemiaBusinessException("Impossible d'annuler la session");
    }

    @Override
    public SessionRepository getDAO() {
        return sessionRepository;
    }
}
