package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.PlanificationRepository;
import af.cmr.indyli.akademia.business.dto.basic.PlanificationBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.PlanificationFullDTO;
import af.cmr.indyli.akademia.business.entity.Planification;

public interface IPlanificationService extends IAbstractAkdemiaService<Planification, PlanificationBasicDTO, PlanificationFullDTO, PlanificationRepository> {
}