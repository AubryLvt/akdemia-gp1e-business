package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.PrivilegeRepository;
import af.cmr.indyli.akademia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.PrivilegeFullDTO;
import af.cmr.indyli.akademia.business.entity.Privilege;
import af.cmr.indyli.akademia.business.service.IPrivilegeService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service(ConstsValues.ServiceKeys.PRIVILEGE_SERVICE_KEY)
public class PrivilegeServiceImpl extends AbstractAkdemiaServiceImpl<Privilege, PrivilegeBasicDTO, PrivilegeFullDTO, PrivilegeRepository> implements IPrivilegeService {

    @Resource(name = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
    private PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl() {
        super(Privilege.class, PrivilegeBasicDTO.class, PrivilegeFullDTO.class);
    }

    @Override
    public PrivilegeRepository getDAO() {
        return this.privilegeRepository;
    }
}