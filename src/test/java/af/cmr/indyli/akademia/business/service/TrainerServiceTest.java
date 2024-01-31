package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrainerServiceTest {
    @Resource(name = ConstsValues.ServiceKeys.TRAINER_SERVICE_KEY)
    private ITrainerService trainerService;

    private TrainerFullDTO trainerForAllTest = null;
    private Integer idCratedTrainer = null;

    @BeforeEach
    void setUp() throws AkdemiaBusinessException {
        TrainerFullDTO trainer = getSampleTrainer();
        trainer = this.trainerService.create(trainer);

        this.trainerForAllTest = trainer;

        assertNotNull(trainer);
    }

    @Test
    void testCreate() throws AkdemiaBusinessException {
        TrainerFullDTO trainer = getSampleTrainer();
        trainer.setEmail("newTrainer@gmail.com");
        trainer = this.trainerService.create(trainer);
        idCratedTrainer = trainer.getId();

        assertNotNull(trainer);
    }

    @Test
    void testFindAll() {
        List<TrainerBasicDTO> trainers = this.trainerService.findAll();

        assertEquals(1, trainers.size());
    }

    @Test
    void testFindById() throws AkdemiaBusinessException {
        TrainerFullDTO trainer = this.trainerService.findById(this.trainerForAllTest.getId());
        assertNotNull(trainer);
        assertEquals(trainer.getAddress(), this.trainerForAllTest.getAddress());
    }

    @Test
    void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
        TrainerFullDTO trainerToUpdate = getSampleTrainer();
        String updateAddr = "Updated Addr";
        trainerToUpdate.setId(this.trainerForAllTest.getId());
        trainerToUpdate.setAddress(updateAddr);

        TrainerFullDTO updatedTrainer = this.trainerService.update(trainerToUpdate);
        assertEquals(updateAddr, updatedTrainer.getAddress());
    }

    @Test
    void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
        this.trainerService.deleteById(this.trainerForAllTest.getId());

        assertNull(this.trainerService.findById(this.trainerForAllTest.getId()));
        this.trainerForAllTest = null;
    }

    @AfterEach
    void rollback() throws AkdemiaBusinessException, AccessDeniedException {
        if (this.trainerForAllTest != null) this.trainerService.deleteById(this.trainerForAllTest.getId());
        if (idCratedTrainer != null) this.trainerService.deleteById(idCratedTrainer);
    }

    TrainerFullDTO getSampleTrainer() {
        TrainerFullDTO user = new TrainerFullDTO();
        user.setPhone("123456789");
        user.setEmail("example@example.com");
        user.setAddress("123 Example Street, City");
        user.setLogin("example_user");
        user.setPassword("example_password");
        user.setPhoto("path/to/photo.jpg");
        user.setCreationDate(new Date());
        user.setUpdateDate(new Date());
        user.setActivity("Cowboy");
        return user;
    }
}
