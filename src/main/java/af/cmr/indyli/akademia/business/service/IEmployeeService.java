package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.EmployeeRepository;
import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akademia.business.entity.Employee;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

public interface IEmployeeService extends IAbstractAkdemiaService<Employee, EmployeeBasicDTO, EmployeeFullDTO, EmployeeRepository> {

    public EmployeeFullDTO findEmployeeByCompany(Integer idCompany) throws AkdemiaBusinessException;
}
