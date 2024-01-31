package af.cmr.indyli.akademia.business.service.impl;

import af.cmr.indyli.akademia.business.dao.ManagerRepository;
import af.cmr.indyli.akademia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.ManagerFullDTO;
import af.cmr.indyli.akademia.business.entity.Manager;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IManagerService;
import af.cmr.indyli.akademia.business.service.IUserService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import af.cmr.indyli.akademia.business.utils.ReglesGestion;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Service(ConstsValues.ServiceKeys.MANAGER_SERVICE_KEY)
public class ManagerServiceImpl extends AbstractAkdemiaServiceImpl<Manager, ManagerBasicDTO, ManagerFullDTO, ManagerRepository> implements IManagerService {
    @Resource(name = ConstsValues.ConstsDAO.MANAGER_DAO_KEY)
    private ManagerRepository managerRepository;
    @Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
    private IUserService userService;

    public ManagerServiceImpl() {
        super(Manager.class, ManagerBasicDTO.class, ManagerFullDTO.class);
    }

    @Override
    public ManagerRepository getDAO() {
        return this.managerRepository;
    }

    @Override
    public ManagerFullDTO create(ManagerFullDTO view) throws AkdemiaBusinessException {
        if (!userService.isExistUserByEmail(view.getEmail())) {
            view.setCreationDate(new Date());
            Manager entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Manager.class));

            return this.getModelMapper().map(entity, ManagerFullDTO.class);
        }
        throw new AkdemiaBusinessException(ReglesGestion.RG02);
    }

    @Override
    public ManagerFullDTO update(ManagerFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
        if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
            viewToUpdate.setUpdateDate(new Date());
            Manager entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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

}
