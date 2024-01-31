package af.cmr.indyli.akademia.business.service;


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
import java.util.Date;

@SpringBootTest
public class SessionServiceTest {
    @Resource(name = ConstsValues.ServiceKeys.MANAGER_SERVICE_KEY)
    private IManagerService managerService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
    private ITrainerService trainerService;
    @Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
    private ITrainingService trainingService;
    @Resource(name = ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
    private IntraSessionService intraSessionService;
    @Resource(name = ConstsValues.ServiceKeys.SESSION_SERVICE_KEY)
    private ISessionService sessionService;
    private TrainingFullDTO trainingForAllTest = null;
    private TrainerFullDTO trainerForAllTest = null;
    private IntraSessionFullDTO intraSessionForAllTest = null;


    @BeforeEach
    void setup() throws AkdemiaBusinessException {
        this.trainerForAllTest = this.trainerService.create(getSampleTrainer());
        this.trainingForAllTest = this.trainingService.create(getSampleTraining());


        IntraSessionFullDTO intraSession = getSampleIntraSession();
        intraSession.setTrainer(this.trainerForAllTest);
        intraSession.setTraining(this.trainingForAllTest);
        intraSession = this.intraSessionService.create(intraSession);
        this.intraSessionForAllTest = intraSession;
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        this.intraSessionService.deleteForce(this.intraSessionForAllTest.getId());;
        this.trainerService.deleteById(this.trainerForAllTest.getId());
        this.trainingService.deleteById(this.trainingForAllTest.getId());


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
        user.setEmail("trainer@new.com");
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

    IntraSessionFullDTO getSampleIntraSession() {
        IntraSessionFullDTO session = new IntraSessionFullDTO();
        session.setCode("ABC123");
        session.setDuration(120);
        session.setDescription("Example session description");
        session.setStatus(Status.OPEN);
        session.setDate(new Date());
        session.setLocation("Local A1");
        session.setSessionScore(85);
        session.setCreationDate(new Date());
        session.setUpdateDate(new Date());

        return session;
    }
}
