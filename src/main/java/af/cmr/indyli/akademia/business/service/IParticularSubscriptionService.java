package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.ParticularSouscriptionRepository;
import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akademia.business.dto.full.ParticularSubscriptionFullDTO;
import af.cmr.indyli.akademia.business.entity.ParticularSubscription;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

import java.util.List;


public interface IParticularSubscriptionService extends IAbstractAkdemiaService<ParticularSubscription, ParticularSubscriptionBasicDTO, ParticularSubscriptionFullDTO, ParticularSouscriptionRepository> {
    public InterSessionFullDTO create(Integer interSessionId, List<Integer> particularsId) throws AkdemiaBusinessException;

    public void delete(Integer interSessionId, Integer particularId) throws AkdemiaBusinessException;
}
