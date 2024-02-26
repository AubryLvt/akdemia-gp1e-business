package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IValidationTestRepository;
import af.cmr.indyli.akademia.business.dto.basic.ValidationTestBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ValidationTestFullDTO;
import af.cmr.indyli.akademia.business.entity.ValidationTest;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing skill
 * validation tests, providing specific operations for {@link ValidationTest}
 * entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IValidationTestService extends
		IAbstractAkdemiaService<ValidationTest, ValidationTestBasicDTO, ValidationTestFullDTO, IValidationTestRepository> {

}