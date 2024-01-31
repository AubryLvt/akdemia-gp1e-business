package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.ValidationTestRepository;
import af.cmr.indyli.akademia.business.dto.basic.ValidationTestBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ValidationTestFullDTO;
import af.cmr.indyli.akademia.business.entity.ValidationTest;

public interface IValidationTestService extends IAbstractAkdemiaService<ValidationTest, ValidationTestBasicDTO, ValidationTestFullDTO, ValidationTestRepository> {
}