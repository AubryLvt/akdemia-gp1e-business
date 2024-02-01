package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.IntraSessionRepository;
import af.cmr.indyli.akademia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akademia.business.entity.IntraSession;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

import java.nio.file.AccessDeniedException;

public interface IntraSessionService extends IAbstractAkdemiaService<IntraSession, IntraSessionBasicDTO, IntraSessionFullDTO, IntraSessionRepository> {
    public void deleteForce(int id);
}
