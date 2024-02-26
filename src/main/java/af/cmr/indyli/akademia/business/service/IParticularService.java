package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IParticularRepository;
import af.cmr.indyli.akademia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ParticularFullDTO;
import af.cmr.indyli.akademia.business.entity.Particular;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * particular, providing specific operations for {@link Particular} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IParticularService
		extends IAbstractAkdemiaService<Particular, ParticularBasicDTO, ParticularFullDTO, IParticularRepository> {
}
