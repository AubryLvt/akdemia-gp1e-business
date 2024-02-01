package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.IntraSessionFullDTO;
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
public class IntraSessionServiceTest {

    @Resource(name = ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
    private IntraSessionService intraSessionService;

    @Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
    private ITrainerService trainerService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
    private ITrainingService trainingService;
    private IntraSessionFullDTO intraSessionForAllTest = null;
    private TrainingFullDTO trainingForAllTest = null;


    private TrainerFullDTO trainerForAllTest = null;
    private Integer idCratedSession = null;

    @BeforeEach
    void setUp() throws AkdemiaBusinessException {
        this.trainerForAllTest = this.trainerService.create(getSampleTrainer());
        this.trainingForAllTest = this.trainingService.create(getSampleTraining());

        IntraSessionFullDTO intraSession = getSampleIntraSession();
        intraSession.setTrainer(this.trainerForAllTest);
        intraSession.setTraining(this.trainingForAllTest);
        intraSession = this.intraSessionService.create(intraSession);
        this.intraSessionForAllTest = intraSession;

        assertNotNull(trainerForAllTest);
        assertNotNull(trainingForAllTest);
        assertNotNull(intraSession);
    }

    @Test
    void testCreate() throws AkdemiaBusinessException {
        IntraSessionFullDTO intraSession = getSampleIntraSession();
        intraSession.setCode("ABBVC");

        intraSession.setTrainer(this.trainerForAllTest);
        intraSession.setTraining(this.trainingForAllTest);
        intraSession = this.intraSessionService.create(intraSession);
        this.idCratedSession = intraSession.getId();

        assertNotNull(trainerForAllTest);
        assertNotNull(trainingForAllTest);
        assertNotNull(intraSession);
    }

    @Test
    void testFindAll() {
        List<IntraSessionBasicDTO> intraSessions = this.intraSessionService.findAll();

        assertEquals(1, intraSessions.size());
    }

    @Test
    void testFindById() throws AkdemiaBusinessException {
        IntraSessionFullDTO intraSession = this.intraSessionService.findById(this.intraSessionForAllTest.getId());
        assertNotNull(intraSession);
        assertEquals(intraSession.getCode(), this.intraSessionForAllTest.getCode());
    }

    @Test
    void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
        IntraSessionFullDTO intraSessionToUpdate = getSampleIntraSession();
        String updateCode = "New Code";
        intraSessionToUpdate.setId(this.intraSessionForAllTest.getId());
        intraSessionToUpdate.setCode(updateCode);

        IntraSessionFullDTO updatedIntraSession = this.intraSessionService.update(intraSessionToUpdate);
        assertEquals(updateCode, updatedIntraSession.getCode());
    }

    @Test
    void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
        this.intraSessionService.deleteById(this.intraSessionForAllTest.getId());

        assertEquals(Status.CANCELLED, this.intraSessionService.findById(this.intraSessionForAllTest.getId()).getStatus());
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        this.intraSessionService.deleteForce(this.intraSessionForAllTest.getId());
        if (idCratedSession != null) this.intraSessionService.deleteForce(idCratedSession);
        this.trainerService.deleteById(this.trainerForAllTest.getId());
        this.trainingService.deleteById(this.trainingForAllTest.getId());

    }

    IntraSessionFullDTO getSampleIntraSession() {
        IntraSessionFullDTO session = new IntraSessionFullDTO();
        session.setCode("ABC124");
        session.setDuration(120);
        session.setDescription("Example session description");
        session.setStatus(Status.OPEN);
        session.setDate(Date.from(LocalDate.now().plusMonths(4).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        session.setLocation("Local A1");
        session.setSessionScore(85);
        session.setCreationDate(new Date());
        session.setUpdateDate(new Date());

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
        user.setEmail("manager@example.com");
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