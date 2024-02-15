package af.cmr.indyli.akademia.business.service.impl;


import af.cmr.indyli.akademia.business.dao.CompanyRepository;
import af.cmr.indyli.akademia.business.dao.EmployeeRepository;
import af.cmr.indyli.akademia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akademia.business.entity.Company;
import af.cmr.indyli.akademia.business.entity.Employee;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IEmployeeService;
import af.cmr.indyli.akademia.business.service.IUserService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

@Service(ConstsValues.ServiceKeys.EMPLOYEE_SERVICE_KEY)
public class EmployeeServiceImpl extends AbstractAkdemiaServiceImpl<Employee, EmployeeBasicDTO, EmployeeFullDTO, EmployeeRepository> implements IEmployeeService {
    @Resource(name = ConstsValues.ConstsDAO.EMPLOYEE_DAO_KEY)
    private EmployeeRepository employeeRepository;

    @Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
    private IUserService userService;

    @Resource(name = ConstsValues.ConstsDAO.COMPANY_DAO_KEY)
    private CompanyRepository companyRepository;


    public EmployeeServiceImpl() {
        super(Employee.class, EmployeeBasicDTO.class, EmployeeFullDTO.class);
    }

    @Override
    public EmployeeRepository getDAO() {
        return this.employeeRepository;
    }

    @Override
    public EmployeeFullDTO findEmployeeByCompany(Integer idCompany) throws AkdemiaBusinessException {
        Company company = companyRepository.findById(idCompany).orElse(null);
        if (company == null) throw new AkdemiaBusinessException("Cette entreprise n'existe pas");
        return getModelMapper().map(getDAO().findByCompany(company), EmployeeFullDTO.class);
    }

    @Override
    public EmployeeFullDTO create(EmployeeFullDTO view) throws AkdemiaBusinessException {
        if (!userService.isExistUserByEmail(view.getEmail())) {
            view.setCreationDate(new Date());
            Employee entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Employee.class));

            return this.getModelMapper().map(entity, EmployeeFullDTO.class);
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG02);
    }

    @Override
    public EmployeeFullDTO update(EmployeeFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
            viewToUpdate.setUpdateDate(new Date());
            Employee entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
            if (entity != null) {
                BeanUtils.copyProperties(viewToUpdate, entity);
                this.getDAO().saveAndFlush(entity);
            } else {
                throw new AkdemiaBusinessException("L'objet à modifier N'existe pas en Base...");
            }
            return viewToUpdate;
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG02);
    }

    @Override
    public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
        var tmpEmployee = this.findById(id);

        if (tmpEmployee == null) {
            throw new AkdemiaBusinessException("L'objet à supprimer n'existe pas en Base...");
        }
        // TODO: 15/02/2024 "T9: ajoutez un bloc else-if pour gérer la RG16"

        getDAO().deleteById(id);

    }
}
	
