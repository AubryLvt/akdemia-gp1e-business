package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.TestRepository;
import af.cmr.indyli.akademia.business.dto.basic.TestBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TestFullDTO;
import af.cmr.indyli.akademia.business.entity.Test;
import af.cmr.indyli.akademia.business.service.ITestService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.TEST_SERVICE_KEY)
public class TestServiceImpl extends
        AbstractAkdemiaServiceImpl<Test, TestBasicDTO, TestFullDTO, TestRepository>
        implements ITestService {

    @Resource(name = ConstsValues.ConstsDAO.TEST_DAO_KEY)
    private TestRepository testRepository;

    public TestServiceImpl() {
        super(Test.class, TestBasicDTO.class, TestFullDTO.class);
    }

    @Override
    public TestRepository getDAO() {
        return this.testRepository;
    }
}
