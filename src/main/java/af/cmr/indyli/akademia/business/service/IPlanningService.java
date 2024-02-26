package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IPlanningRepository;
import af.cmr.indyli.akademia.business.dto.basic.PlanningBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.PlanningFullDTO;
import af.cmr.indyli.akademia.business.entity.Planning;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * planning, providing specific operations for {@link Planning} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IPlanningService
		extends IAbstractAkdemiaService<Planning, PlanningBasicDTO, PlanningFullDTO, IPlanningRepository> {
}