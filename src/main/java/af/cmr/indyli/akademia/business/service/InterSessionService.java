package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.InterSessionRepository;
import af.cmr.indyli.akademia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akademia.business.entity.InterSession;


public interface InterSessionService extends IAbstractAkdemiaService<InterSession, InterSessionBasicDTO, InterSessionFullDTO, InterSessionRepository> {
    public void deleteForce(int id);
}
