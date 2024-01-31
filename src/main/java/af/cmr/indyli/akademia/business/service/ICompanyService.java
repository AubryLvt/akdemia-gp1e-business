package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.CompanyRepository;
import af.cmr.indyli.akademia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akademia.business.entity.Company;

public interface ICompanyService extends IAbstractAkdemiaService<Company, CompanyBasicDTO, CompanyFullDTO, CompanyRepository> {
}