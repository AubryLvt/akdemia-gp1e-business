package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.CompanyRepository;
import af.cmr.indyli.akademia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akademia.business.entity.Company;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.ICompanyService;
import af.cmr.indyli.akademia.business.service.IUserService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.COMPANY_SERVICE_KEY)
public class CompanyServiceImpl extends AbstractAkdemiaServiceImpl<Company, CompanyBasicDTO, CompanyFullDTO, CompanyRepository> implements ICompanyService {
    @Resource(name = ConstsValues.ConstsDAO.COMPANY_DAO_KEY)
    private CompanyRepository companyRepository;

    @Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
    private IUserService userService;

    public CompanyServiceImpl() {
        super(Company.class, CompanyBasicDTO.class, CompanyFullDTO.class);

    }

    @Override
    public CompanyFullDTO create(CompanyFullDTO view) throws AkdemiaBusinessException {
        if (!userService.isExistUserByEmail(view.getEmail())) {
            view.setCreationDate(new Date());
            Company entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Company.class));

            return this.getModelMapper().map(entity, CompanyFullDTO.class);
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG02);
    }

    @Override
    public CompanyFullDTO update(CompanyFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
            viewToUpdate.setUpdateDate(new Date());
            Company entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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
        var tmpCompany = this.findById(id);

        if (tmpCompany == null) {
            throw new AkdemiaBusinessException("L'objet à supprimer n'existe pas en base...");
        } else if (!tmpCompany.getIntraSessions().isEmpty()) {
            throw new AkdemiaBusinessException(ReglesGestion.RG19);
        }

        getDAO().deleteById(id);
    }

    @Override
    public CompanyRepository getDAO() {
        return this.companyRepository;
    }

}
