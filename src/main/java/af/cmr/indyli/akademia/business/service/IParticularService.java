package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.ParticularRepository;
import af.cmr.indyli.akademia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ParticularFullDTO;
import af.cmr.indyli.akademia.business.entity.Particular;

public interface IParticularService extends IAbstractAkdemiaService<Particular, ParticularBasicDTO, ParticularFullDTO, ParticularRepository> {
}
