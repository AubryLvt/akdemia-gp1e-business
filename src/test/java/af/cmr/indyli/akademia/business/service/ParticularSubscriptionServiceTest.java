package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dto.basic.ParticularSubscriptionBasicDTO;
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
public class ParticularSubscriptionServiceTest {

    @Resource(name = ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
    private InterSessionService interSessionService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
    private ITrainerService trainerService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
    private ITrainingService trainingService;
    @Resource(name = ConstsValues.ServiceKeys.PARTICULAR_SOUSCRIPTION_SERVICE_KEY)
    private IParticularSubscriptionService particularSubscriptionService;
    @Resource(name = ConstsValues.ServiceKeys.PARTICULAR_SERVICE_KEY)
    private IParticularService particularService;
    private InterSessionFullDTO interSessionForAllTest = null;
    private InterSessionFullDTO interSessionCreateTest = null;
    private TrainingFullDTO trainingForAllTest = null;
    private ParticularFullDTO particularForAllTest = null;
    private ParticularSubscriptionFullDTO subscriptionForAllTest = null;
    private TrainerFullDTO trainerForAllTest = null;
    private Integer idCratedSubscription = null;

    private final List<ParticularSubscriptionFullDTO> createdSubscriptionsIds = null;

    @BeforeEach
    void setUp() throws AkdemiaBusinessException {
        this.trainerForAllTest = this.trainerService.create(getSampleTrainer());
        this.trainingForAllTest = this.trainingService.create(getSampleTraining());
        this.particularForAllTest = this.particularService.create(getSampleParticular());
        this.interSessionForAllTest = this.interSessionService.create(getSampleInterSession());

        ParticularSubscriptionFullDTO dto = getSampleParticularSubscription();
        this.subscriptionForAllTest = this.particularSubscriptionService.create(dto);

        assertNotNull(subscriptionForAllTest);

    }

    @Test
    void testCreateLite() throws AkdemiaBusinessException {
        idCratedSubscription = this.particularSubscriptionService.create(getSampleParticularSubscription()).getId();

        assertNotNull(idCratedSubscription);
    }

    @Test
    void testCreate() throws AkdemiaBusinessException {
        List<Integer> particularIds = List.of(particularForAllTest.getId());
        InterSessionFullDTO session = getSampleInterSession();
        session.setCode("0KDQL");
        interSessionCreateTest = this.interSessionService.create(session);
        this.interSessionCreateTest = particularSubscriptionService.create(interSessionCreateTest.getId(), particularIds);

        assertNotNull(this.interSessionForAllTest);
    }

    @Test
    void testFindAll() {
        List<ParticularSubscriptionBasicDTO> subscriptions = this.particularSubscriptionService.findAll();

        assertEquals(1, subscriptions.size());
    }

    @Test
    void testFindById() throws AkdemiaBusinessException {
        ParticularSubscriptionFullDTO particularSubscription = this.particularSubscriptionService.findById(this.subscriptionForAllTest.getId());

        assertNotNull(particularSubscription);
        assertEquals(this.subscriptionForAllTest.getId(), particularSubscription.getId());
    }

    @Test
    void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
        ParticularSubscriptionFullDTO subscriptionToUpdate = getSampleParticularSubscription();
        Date updateDate = new Date();
        subscriptionToUpdate.setUpdateDate(updateDate);

        subscriptionToUpdate.setId(this.subscriptionForAllTest.getId());

        assertEquals(updateDate, this.particularSubscriptionService.update(subscriptionToUpdate).getUpdateDate());
    }

    @Test
    void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
        this.particularSubscriptionService.deleteById(this.subscriptionForAllTest.getId());

        ParticularSubscriptionFullDTO particularSubscription = this.particularSubscriptionService.findById(this.subscriptionForAllTest.getId());

        assertNull(particularSubscription);
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        this.particularSubscriptionService.deleteById(this.subscriptionForAllTest.getId());
        if (idCratedSubscription != null) {
            this.particularSubscriptionService.deleteById(idCratedSubscription);
        }
        this.deleteAllSubscription();
        if (this.interSessionCreateTest != null)
            this.interSessionService.deleteForce(this.interSessionCreateTest.getId());
        this.interSessionService.deleteForce(this.interSessionForAllTest.getId());
        this.particularService.deleteById(particularForAllTest.getId());
        this.trainingService.deleteById(this.trainingForAllTest.getId());
        this.trainerService.deleteById(this.trainerForAllTest.getId());
    }

    void deleteAllSubscription() throws AkdemiaBusinessException {
        if (this.interSessionCreateTest != null) {
            interSessionCreateTest = this.interSessionService.findById(interSessionCreateTest.getId());
            this.interSessionCreateTest.getParticularSubscriptions().forEach(s -> {
                try {
                    this.particularSubscriptionService.deleteById(s.getId());
                } catch (AkdemiaBusinessException | AccessDeniedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    InterSessionFullDTO getSampleInterSession() {
        InterSessionFullDTO session = new InterSessionFullDTO();
        session.setCode("ABC123");
        session.setDuration(120);
        session.setDescription("Example session description");
        session.setStatus(Status.ACTIVE);
        session.setDate(Date.from(LocalDate.now().plusMonths(4).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        session.setLocation("Local A1");
        session.setSessionScore(85);
        session.setCreationDate(new Date());
        session.setMinParticipants(15);
        session.setUpdateDate(new Date());
        session.setTraining(this.trainingForAllTest);
        session.setTrainer(this.trainerForAllTest);

        return session;
    }

    ParticularSubscriptionFullDTO getSampleParticularSubscription() {
        ParticularSubscriptionFullDTO subscription = new ParticularSubscriptionFullDTO();
        subscription.setCreationDate(new Date());
        subscription.setUpdateDate(new Date());
        subscription.setParticular(this.particularForAllTest);
        subscription.setInterSession(this.interSessionForAllTest);
        subscription.setStatus(Status.ACTIVE);

        return subscription;
    }

    ManagerFullDTO getSampleManager() {
        ManagerFullDTO user = new ManagerFullDTO();
        user.setPhone("123456789");
        user.setEmail("example@example.com");
        user.setAddress("123 Example Street, City");
        user.setLogin("example_user");
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setGender("M");
        user.setPassword("example_password");
        user.setPhoto("path/to/photo.jpg");
        user.setCreationDate(new Date());

        return user;
    }

    TrainerFullDTO getSampleTrainer() {
        TrainerFullDTO user = new TrainerFullDTO();
        user.setPhone("123456789");
        user.setEmail("trainer@example.com");
        user.setAddress("123 Example Street, City");
        user.setLogin("example_user");
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setGender("M");
        user.setCvLink("cv-me.com");
        user.setPassword("example_password");
        user.setPhoto("path/to/photo.jpg");
        user.setCreationDate(new Date());
        user.setUpdateDate(new Date());
        user.setActivity("Cowboy");
        return user;
    }

    ParticularFullDTO getSampleParticular() {
        ParticularFullDTO user = new ParticularFullDTO();
        user.setPhone("123456789");
        user.setEmail("particular@example.com");
        user.setAddress("123 Example Street, City");
        user.setLogin("example_user");
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setGender("M");
        user.setPassword("example_password");
        user.setPhoto("path/to/photo.jpg");
        user.setCreationDate(new Date());
        user.setUpdateDate(new Date());
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
}