package af.cmr.indyli.akademia.business.service;


import af.cmr.indyli.akademia.business.dao.EmployeeSouscriptionRepository;
import af.cmr.indyli.akademia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akademia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akademia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;

import java.util.List;

public interface IEmployeeSubscriptionService extends IAbstractAkdemiaService<EmployeeSubscription, EmployeeSubscriptionBasicDTO, EmployeeSubscriptionFullDTO, EmployeeSouscriptionRepository> {
    public IntraSessionFullDTO create(Integer intraSessionId, List<Integer> employeesId) throws AkdemiaBusinessException;


    public List<EmployeeSubscriptionFullDTO> findByIntraSession(Integer sessionId) throws AkdemiaBusinessException;
    public void deleteAfterVerification(Integer subscriptionId) throws AkdemiaBusinessException;
}
