package af.cmr.indyli.akdemia.business.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp1eConfig;
import af.cmr.indyli.akdemia.business.dto.full.ParticularFullDTO;
import af.cmr.indyli.akdemia.business.entity.Particular;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IParticularService;

@ContextConfiguration(classes = { AkdemiaBusinessGp1eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParticularRepositoryTest {

//	@Resource(name = ConstsValues.ServiceKeys.PARTICULAR_SERVICE_KEY)
// => l'annotation genere une erreur, je l'ai remplacé par at autowired
	
	@Autowired
	
	private IParticularService sampleParticularService;
	
	private IParticularRepository sampleParticularRepository;

	private ParticularFullDTO particularForAllTest = null;

	private Integer idCreatedParticular = null;

	/**
	 * Méthode setUp() : Initialise un objet Particular de test.
	 */
//    @BeforeEach
//    void setUp()  throws AkdemiaBusinessException {
//		ParticularFullDTO particular = getSampleParticular();
//
//		this.particularForAllTest = this.sampleParticularRepository.save(particular);
//
//		assertNotNull(particular);
//    	
//    }

	@Test
	void testCreateParticular() throws AkdemiaBusinessException {

		Particular sampleParticular = new Particular();

		sampleParticular.setEmail("particular@gmail.com");
		sampleParticular.setFirstname("John");
		sampleParticular.setLastname("Doe");
		sampleParticular.setGender("Male");
		sampleParticular.setActivity("Software Engineer");
		sampleParticular.setHighestDiploma("Master's Degree in Computer Science");
		sampleParticular.setBirthDate(new Date());

		sampleParticular = this.sampleParticularRepository.save(sampleParticular);
		idCreatedParticular = sampleParticular.getId();

		assertNotNull(sampleParticular);
	}
	
	@Test
	void testCreateParticularFullDTO() throws AkdemiaBusinessException, ParseException {

		ParticularFullDTO sampleParticularFullDTO = getSampleParticular();

		sampleParticularFullDTO.setEmail("particular@gmail.com");
		sampleParticularFullDTO.setFirstname("John");
		sampleParticularFullDTO.setLastname("Doe");
		sampleParticularFullDTO.setGender("Male");
		sampleParticularFullDTO.setActivity("Software Engineer");
		sampleParticularFullDTO.setHighestDiploma("Master's Degree in Computer Science");
		sampleParticularFullDTO.setBirthDate(new Date());

		sampleParticularFullDTO = this.sampleParticularService.create(sampleParticularFullDTO);
		idCreatedParticular = sampleParticularFullDTO.getId();

		assertNotNull(sampleParticularFullDTO);
	}

	ParticularFullDTO getSampleParticular() throws ParseException {
		ParticularFullDTO user = new ParticularFullDTO();
		user.setPhone("123456789");
		user.setEmail("example@example.com");
		user.setAddress("123 Example Street, City");
		user.setLogin("example_user");
		user.setPassword("example_password");
		user.setPhoto("path/to/photo.jpg");
		user.setCreationDate(new Date());
		user.setUpdateDate(new Date());
		user.setFirstname("John");
		user.setLastname("Doe");
		user.setGender("M");
		user.setActivity("Professional Developer");
		user.setHighestDiploma("Master's Degree");
		user.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1990-05-15"));

		return user;
	}

}
