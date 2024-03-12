package af.cmr.indyli.akdemia.business.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp1eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.SubTopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ICompanyService;
import af.cmr.indyli.akdemia.business.service.IEmployeeService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@ContextConfiguration(classes = { AkdemiaBusinessGp1eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

	@Resource(name = ConstsValues.ServiceKeys.EMPLOYEE_SERVICE_KEY)
	private IEmployeeService sampleEmployeeService;
	private EmployeeFullDTO sampleEmployeeFullDTO;
	
	@Resource(name = ConstsValues.ServiceKeys.COMPANY_SERVICE_KEY)
	private ICompanyService sampleCompanyService;
	private CompanyFullDTO sampleCompanyFullDTO = getSampleCompany();

	private Integer idCreatedEmployee;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		CompanyFullDTO company = getSampleCompany();
		this.sampleCompanyFullDTO = this.sampleCompanyService.create(company);
		
		
		EmployeeFullDTO employee = getSampleEmployee();
		employee.setCompany(company);
		this.sampleEmployeeFullDTO = this.sampleEmployeeService.create(employee);
		

		System.out.println("ID CREATE... " + sampleEmployeeFullDTO.getId());

		assertNotNull(company);
		assertNotNull(employee);
	}

	@Test
	void testCreateEmployeeFullDTO() throws AkdemiaBusinessException {
		EmployeeFullDTO employee = getSampleEmployee();
		employee.setCompany(sampleCompanyFullDTO);

		employee.setEmail("albert.dupond@example.com");
		employee = this.sampleEmployeeService.create(employee);
		idCreatedEmployee = employee.getId();
		

		assertNotNull(employee);
	}

	@Test
	void testFindAll() {
		List<EmployeeBasicDTO> employees = this.sampleEmployeeService.findAll();

		assertEquals(0, employees.size());
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
		user.setFirstname("John");
		user.setLastname("Doe");
		user.setGender("M");
//		user.setCompany(sampleCompanyFullDTO);

		return user;
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
