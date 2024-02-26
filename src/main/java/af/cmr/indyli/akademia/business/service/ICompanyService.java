package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.ICompanyRepository;
import af.cmr.indyli.akademia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akademia.business.entity.Company;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * companies, providing specific operations for {@link Company} entities.
 *
 * @see IAbstractAkdemiaService
 */

public interface ICompanyService
		extends IAbstractAkdemiaService<Company, CompanyBasicDTO, CompanyFullDTO, ICompanyRepository> {
}