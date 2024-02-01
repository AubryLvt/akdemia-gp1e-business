package af.cmr.indyli.akademia.business.service.impl;


import af.cmr.indyli.akademia.business.dao.InterSessionRepository;
import af.cmr.indyli.akademia.business.dao.ParticularRepository;
import af.cmr.indyli.akademia.business.dao.ParticularSouscriptionRepository;
import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akademia.business.dto.full.ParticularSubscriptionFullDTO;
import af.cmr.indyli.akademia.business.entity.InterSession;
import af.cmr.indyli.akademia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akademia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akademia.business.dto.full.ParticularSubscriptionFullDTO;
import af.cmr.indyli.akademia.business.entity.InterSession;
import af.cmr.indyli.akademia.business.entity.IntraSession;
import af.cmr.indyli.akademia.business.entity.Particular;
import af.cmr.indyli.akademia.business.entity.ParticularSubscription;
import af.cmr.indyli.akademia.business.entity.Status;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IParticularSubscriptionService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service(ConstsValues.ServiceKeys.PARTICULAR_SOUSCRIPTION_SERVICE_KEY)
public class ParticularSubscriptionServiceImpl extends AbstractAkdemiaServiceImpl<ParticularSubscription, ParticularSubscriptionBasicDTO, ParticularSubscriptionFullDTO, ParticularSouscriptionRepository> implements IParticularSubscriptionService {

    @Resource(name = ConstsValues.ConstsDAO.PARTICULAR_SOUSCRIPTION_DAO_KEY)
    private ParticularSouscriptionRepository particularSouscriptionRepository;

    @Resource(name = ConstsValues.ConstsDAO.PARTICULAR_DAO_KEY)
    private ParticularRepository particularRepository;

    @Resource(name = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
    private InterSessionRepository interSessionRepository;

    public ParticularSubscriptionServiceImpl() {
        super(ParticularSubscription.class, ParticularSubscriptionBasicDTO.class, ParticularSubscriptionFullDTO.class);

    }

    @Override
    public ParticularSouscriptionRepository getDAO() {
        return this.particularSouscriptionRepository;
    }

    @Override
    public InterSessionFullDTO create(Integer interSessionId, List<Integer> particularsId) throws AkdemiaBusinessException {

        InterSession interSession = interSessionRepository.findById(interSessionId).orElse(null);
        if (interSession == null) throw new AkdemiaBusinessException("La session n'existe pas");
        particularsId.forEach((id) -> {
            Particular p = particularRepository.findById(id).orElse(null);
            if (p != null) {
                ParticularSubscription particularSubscription = new ParticularSubscription();
                particularSubscription.setParticular(p);
                particularSubscription.setInterSession(interSession);
                particularSubscription.setCreationDate(new Date());
                particularSubscription.setStatus(Status.IN_PROGRESS);
                particularSouscriptionRepository.save(particularSubscription);
            }
        });

        return getModelMapper().map(interSession, InterSessionFullDTO.class);
    }

    @Override
    public void delete(Integer interSessionId, Integer particularId) throws AkdemiaBusinessException {

        Particular particular = particularRepository.findById(particularId).orElse(null);
        if (particular == null) throw new AkdemiaBusinessException("L'étudiant n'existe pas");

        InterSession session = interSessionRepository.findById(interSessionId).orElse(null);
        if (session == null) throw new AkdemiaBusinessException("La session n'existe pas");

        Date today = new Date();
        LocalDate todayLocalDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate sessionLocalDate = session.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long difference = ChronoUnit.DAYS.between(todayLocalDate, sessionLocalDate);
        if (difference < 15) throw new AkdemiaBusinessException("La date de début est proche de moin de 15 jours");

        List<ParticularSubscription> particularSubscriptions = particularSouscriptionRepository.findAll();

        particularSubscriptions.forEach((subscription) -> {
            Integer subscriptionParticularId = subscription.getParticular().getId();
            Integer subscriptionInterSessionId = subscription.getInterSession().getId();
            if (subscriptionParticularId.equals(particularId) && subscriptionInterSessionId.equals(interSessionId))
                getDAO().delete(subscription);
        });
    }

    @Override
    public List<ParticularSubscriptionFullDTO> findByInterSession(Integer sessionId) throws AkdemiaBusinessException {
        InterSession session = interSessionRepository.findById(sessionId).orElse(null);
        if(session == null)
            throw new AkdemiaBusinessException("La session inter est introuvable");

        return this.getDAO().findByInterSession(session)
                .stream().map(employeeSubscription ->
                        getModelMapper().map(employeeSubscription, ParticularSubscriptionFullDTO.class)).toList();
    }
}