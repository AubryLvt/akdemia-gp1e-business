package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akademia.business.dto.full.ManagerFullDTO;
import af.cmr.indyli.akademia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akademia.business.dto.full.TrainingFullDTO;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InterSessionServiceTest {

    @Resource(name = ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
    private InterSessionService interSessionService;

    @Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
    private ITrainerService trainerService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
    private ITrainingService trainingService;
    private InterSessionFullDTO interSessionForAllTest = null;
    private TrainingFullDTO trainingForAllTest = null;


    private TrainerFullDTO trainerForAllTest = null;
    private Integer idCratedSession = null;

    @BeforeEach
    void setUp() throws AkdemiaBusinessException {
        this.trainerForAllTest = this.trainerService.create(getSampleTrainer());
        this.trainingForAllTest = this.trainingService.create(getSampleTraining());

        InterSessionFullDTO interSession = getSampleInterSession();
        interSession.setTrainer(this.trainerForAllTest);
        interSession.setTraining(this.trainingForAllTest);
        interSession = this.interSessionService.create(interSession);
        this.interSessionForAllTest = interSession;

        assertNotNull(trainerForAllTest);
        assertNotNull(trainingForAllTest);
        assertNotNull(interSession);
    }

    @Test
    void testCreate() throws AkdemiaBusinessException {
        InterSessionFullDTO interSession = getSampleInterSession();
        interSession.setCode("ABC124");
        this.idCratedSession = this.interSessionService.create(interSession).getId();


        assertNotNull(idCratedSession);
    }

    @Test
    void testFindAll() {
        List<InterSessionBasicDTO> interSessions = this.interSessionService.findAll();

        assertEquals(1, interSessions.size());
    }

    @Test
    void testFindById() throws AkdemiaBusinessException {
        InterSessionFullDTO interSession = this.interSessionService.findById(this.interSessionForAllTest.getId());
        assertNotNull(interSession);
        assertEquals(interSession.getCode(), this.interSessionForAllTest.getCode());
    }

    @Test
    void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
        InterSessionFullDTO interSessionToUpdate = getSampleInterSession();
        String updateCode = "ABC123";
        interSessionToUpdate.setId(this.interSessionForAllTest.getId());
        interSessionToUpdate.setCode(updateCode);

        InterSessionFullDTO updatedInterSession = this.interSessionService.update(interSessionToUpdate);
        assertEquals(updateCode, updatedInterSession.getCode());
    }

    @Test
    void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
        this.interSessionService.deleteById(this.interSessionForAllTest.getId());

        assertEquals(Status.CANCELLED, this.interSessionService.findById(this.interSessionForAllTest.getId()).getStatus());
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        this.interSessionService.deleteForce(this.interSessionForAllTest.getId());
        if (idCratedSession != null) this.interSessionService.deleteForce(idCratedSession);
        this.trainerService.deleteById(this.trainerForAllTest.getId());
        this.trainingService.deleteById(this.trainingForAllTest.getId());


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
        session.setTrainer(this.trainerForAllTest);
        session.setTraining(this.trainingForAllTest);

        return session;
    }

    ManagerFullDTO getSampleManager() {
        ManagerFullDTO user = new ManagerFullDTO();
        user.setPhone("123456789");
        user.setEmail("example@example.com");
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
        user.setEmail("trainer@example.com");
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
}
