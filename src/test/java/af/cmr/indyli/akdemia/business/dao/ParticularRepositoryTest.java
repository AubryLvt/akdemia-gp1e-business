package af.cmr.indyli.akdemia.business.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp1eConfig;
import af.cmr.indyli.akdemia.business.dto.full.ParticularFullDTO;
import af.cmr.indyli.akdemia.business.entity.Particular;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@ContextConfiguration(classes={AkdemiaBusinessGp1eConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ParticularRepositoryTest {
	
	@Resource(name = ConstsValues.ServiceKeys.PARTICULAR_SERVICE_KEY)
    private IParticularRepository sampleParticularRepository;

    private Particular sampleParticular;
    
    
    /**
     * Méthode setUp() : Initialise un objet Particular de test.
     */
    @BeforeEach
    void setUp() {
        sampleParticular = getSampleParticular(); // Crée un objet Particular de test grâce à une méthode du DTO
        sampleParticularRepository.save(sampleParticular); // Enregistre l'objet dans la base de données.
        assertNotNull(sampleParticular.getId()); // Vérifie que l'identifiant généré n'est pas nul.
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
