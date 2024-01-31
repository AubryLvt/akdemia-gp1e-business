package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.ValidationTestRepository;
import af.cmr.indyli.akademia.business.dto.basic.ValidationTestBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ValidationTestFullDTO;
import af.cmr.indyli.akademia.business.entity.ValidationTest;
import af.cmr.indyli.akademia.business.service.IValidationTestService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.VALIDATION_TEST_SERVICE_KEY)
public class ValidationTestServiceImpl extends AbstractAkdemiaServiceImpl<ValidationTest, ValidationTestBasicDTO, ValidationTestFullDTO, ValidationTestRepository> implements IValidationTestService {

    @Resource(name = ConstsValues.ConstsDAO.VALIDATION_TEST_DAO_KEY)
    private ValidationTestRepository validationTestRepository;

    public ValidationTestServiceImpl() {
        super(ValidationTest.class, ValidationTestBasicDTO.class, ValidationTestFullDTO.class);
    }

    @Override
    public ValidationTestRepository getDAO() {
        return this.validationTestRepository;
    }
}