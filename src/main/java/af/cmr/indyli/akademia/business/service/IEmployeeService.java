package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.IEmployeeRepository;
import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akademia.business.entity.Employee;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

import java.util.List;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * employees, providing specific operations for {@link Employee} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IEmployeeService
		extends IAbstractAkdemiaService<Employee, EmployeeBasicDTO, EmployeeFullDTO, IEmployeeRepository> {

	public EmployeeFullDTO findEmployeeByCompany(Integer idCompany) throws AkdemiaBusinessException;

	public List<EmployeeFullDTO> findAllFull();
}
