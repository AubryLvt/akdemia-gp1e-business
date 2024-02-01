package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.TestRepository;
import af.cmr.indyli.akademia.business.dto.basic.TestBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TestFullDTO;
import af.cmr.indyli.akademia.business.entity.Test;

public interface ITestService extends IAbstractAkdemiaService<Test, TestBasicDTO, TestFullDTO, TestRepository> {
    // Ajoutez ici des méthodes spécifiques au service si nécessaire
}