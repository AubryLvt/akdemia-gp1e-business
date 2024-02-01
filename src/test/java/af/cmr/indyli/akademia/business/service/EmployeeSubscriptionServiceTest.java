package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.*;
import af.cmr.indyli.akademia.business.entity.Status;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeSubscriptionServiceTest {

    @Resource(name = ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
    private IntraSessionService intraSessionService;

    @Resource(name = ConstsValues.ServiceKeys.EMPLOYEE_SOUSCRIPTION_SERVICE_KEY)
    private IEmployeeSubscriptionService employeeSubscriptionService;
    @Resource(name = ConstsValues.ServiceKeys.EMPLOYEE_SERVICE_KEY)
    private IEmployeeService employeeService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
    private ITrainerService trainerService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
    private ITrainingService trainingService;
    @Resource(name = ConstsValues.ServiceKeys.COMPANY_SERVICE_KEY)
    private ICompanyService companyService;

    private IntraSessionFullDTO intraSessionForAllTest = null;
    private IntraSessionFullDTO intraSessionForCreateTest = null;
    private ManagerFullDTO managerForAllTest = null;
    private TrainerFullDTO trainerForAllTest = null;
    private TrainingFullDTO trainingForAllTest = null;
    private EmployeeFullDTO employeeForAllTest = null;
    private CompanyFullDTO companyForAllTest = null;
    private EmployeeSubscriptionFullDTO subscriptionForAllTest = null;
    private Integer idCratedSubscription = null;
    private final List<EmployeeSubscriptionFullDTO> createdSubscriptionsIds = null;

    @BeforeEach
    void setUp() throws AkdemiaBusinessException {
        this.trainerForAllTest = this.trainerService.create(getSampleTrainer());
        this.trainingForAllTest = this.trainingService.create(getSampleTraining());
        this.companyForAllTest = this.companyService.create(getSampleCompany());

        this.employeeForAllTest = this.employeeService.create(getSampleEmployee());
        this.intraSessionForAllTest = this.intraSessionService.create(getSampleIntraSession());

        this.subscriptionForAllTest = this.employeeSubscriptionService.create(getSampleEmployeeSubscription());
    }

    @Test
    void testCreateLite() throws AkdemiaBusinessException {
        idCratedSubscription = this.employeeSubscriptionService.create(getSampleEmployeeSubscription()).getId();

        assertNotNull(idCratedSubscription);
    }

    @Test
    void testCreate() throws AkdemiaBusinessException {
        List<Integer> employeeIds = List.of(employeeForAllTest.getId());
        IntraSessionFullDTO dto = getSampleIntraSession();
        dto.setCode("APOSD");
        this.intraSessionForCreateTest = this.intraSessionService.create(dto);
        this.intraSessionForCreateTest = employeeSubscriptionService.create(intraSessionForCreateTest.getId(), employeeIds);

        assertNotNull(this.intraSessionForAllTest);
    }

    @Test
    void testFindAll() {
        List<EmployeeSubscriptionBasicDTO> subscriptions = this.employeeSubscriptionService.findAll();

        assertEquals(1, subscriptions.size());
    }

    @Test
    void testFindById() throws AkdemiaBusinessException {
        EmployeeSubscriptionFullDTO employeeSubscription = this.employeeSubscriptionService.findById(this.subscriptionForAllTest.getId());

        assertNotNull(employeeSubscription);
        assertEquals(this.subscriptionForAllTest.getId(), employeeSubscription.getId());
    }

    @Test
    void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
        EmployeeSubscriptionFullDTO subscriptionToUpdate = getSampleEmployeeSubscription();
        Date updateDate = new Date();
        subscriptionToUpdate.setUpdateDate(updateDate);

        subscriptionToUpdate.setId(this.subscriptionForAllTest.getId());

        assertEquals(updateDate.toString(), this.employeeSubscriptionService.update(subscriptionToUpdate).getUpdateDate().toString());
    }

    @Test
    void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
        this.employeeSubscriptionService.deleteById(this.subscriptionForAllTest.getId());

        EmployeeSubscriptionFullDTO particularSubscription = this.employeeSubscriptionService.findById(this.subscriptionForAllTest.getId());

        assertNull(particularSubscription);
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        this.employeeSubscriptionService.deleteById(this.subscriptionForAllTest.getId());
        if (idCratedSubscription != null) {
            this.employeeSubscriptionService.deleteById(idCratedSubscription);
        }
        this.deleteAllSubscription();
        if (intraSessionForCreateTest != null) this.intraSessionService.deleteForce(intraSessionForCreateTest.getId());
        this.intraSessionService.deleteForce(this.intraSessionForAllTest.getId());
        this.employeeService.deleteById(this.employeeForAllTest.getId());
        this.companyService.deleteById(this.companyForAllTest.getId());
        this.trainingService.deleteById(this.trainingForAllTest.getId());
        this.trainerService.deleteById(this.trainerForAllTest.getId());
    }

    void deleteAllSubscription() throws AkdemiaBusinessException {
        if (intraSessionForCreateTest != null) {
            intraSessionForCreateTest = this.intraSessionService.findById(intraSessionForCreateTest.getId());
            this.intraSessionForCreateTest.getEmployeeSubscriptions().forEach((es) -> {
                try {
                    this.employeeSubscriptionService.deleteById(es.getId());
                } catch (AkdemiaBusinessException | AccessDeniedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    IntraSessionFullDTO getSampleIntraSession() {
        IntraSessionFullDTO session = new IntraSessionFullDTO();
        session.setCode("ABC123");
        session.setDuration(120);
        session.setDescription("Example session description");
        session.setStatus(Status.ACTIVE);
        session.setDate(Date.from(LocalDate.now().plusMonths(4).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        session.setLocation("Local A1");
        session.setSessionScore(85);
        session.setCreationDate(new Date());
        session.setTrainer(this.trainerForAllTest);
        session.setTraining(this.trainingForAllTest);

        return session;
    }

    EmployeeSubscriptionFullDTO getSampleEmployeeSubscription() {
        EmployeeSubscriptionFullDTO subscription = new EmployeeSubscriptionFullDTO();
        subscription.setStatus(Status.ACTIVE);
        subscription.setCreationDate(new Date());
        subscription.setUpdateDate(new Date());
        subscription.setEmployee(this.employeeForAllTest);
        subscription.setIntraSession(this.intraSessionForAllTest);

        return subscription;
    }

    EmployeeFullDTO getSampleEmployee() {
        EmployeeFullDTO user = new EmployeeFullDTO();
        user.setPhone("123456789");
        user.setEmail("example@example.com");
        user.setAddress("123 Example Street, City");
        user.setLogin("example_user");
        user.setPassword("example_password");
        user.setPhoto("path/to/photo.jpg");
        user.setCreationDate(new Date());
        user.setUpdateDate(new Date());
        user.setCompany(this.companyForAllTest);

        return user;
    }

    ManagerFullDTO getSampleManager() {
        ManagerFullDTO user = new ManagerFullDTO();
        user.setPhone("123456789");
        user.setEmail("manager@gmail.com");
        user.setAddress("123 Example Street, City");
        user.setLogin("example_user");
        user.setPassword("example_password");
        user.setPhoto("path/to/photo.jpg");
        user.setCreationDate(new Date());

        return user;
    }

    TrainerFullDTO getSampleTrainer() {
        TrainerFullDTO user = new TrainerFullDTO();
        user.setPhone("123456789");
        user.setEmail("trainer@gmail.com");
        user.setAddress("123 Example Street, City");
        user.setLogin("example_user");
        user.setPassword("example_password");
        user.setPhoto("path/to/photo.jpg");
        user.setCreationDate(new Date());
        user.setUpdateDate(new Date());
        user.setActivity("Cowboy");

        return user;
    }

    TrainingFullDTO getSampleTraining() {
        TrainingFullDTO training = new TrainingFullDTO();
        training.setTitle("Example Training");
        training.setDescription("Example training description");
        training.setTrainingPrice(99.99);
        training.setLogo("path/to/logo.jpg");
        training.setCreationDate(new Date());
        training.setRequirement(null);

        return training;
    }

    CompanyFullDTO getSampleCompany() {
        CompanyFullDTO company = new CompanyFullDTO();
        company.setAddress("DLA");
        company.setEmail("mail@company.com");
        company.setName("SCP");
        company.setLogin("scplog");
        company.setPassword("pass123");
        company.setPhone("08765678900");
        company.setPhoto("/profil/company.jpg");
        company.setActivity("C-Activity");
        company.setCreationDate(new Date());
        return company;
    }

}