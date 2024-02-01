package af.cmr.indyli.akademia.business.service.impl;


import af.cmr.indyli.akademia.business.dao.EmployeeRepository;
import af.cmr.indyli.akademia.business.dao.EmployeeSouscriptionRepository;
import af.cmr.indyli.akademia.business.dao.IntraSessionRepository;
import af.cmr.indyli.akademia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akademia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akademia.business.entity.Employee;
import af.cmr.indyli.akademia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akademia.business.entity.IntraSession;
import af.cmr.indyli.akademia.business.entity.Status;
import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akademia.business.service.IEmployeeSubscriptionService;
import af.cmr.indyli.akademia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service(ConstsValues.ServiceKeys.EMPLOYEE_SOUSCRIPTION_SERVICE_KEY)
public class EmployeeSubscriptionServiceImpl extends AbstractAkdemiaServiceImpl<EmployeeSubscription, EmployeeSubscriptionBasicDTO, EmployeeSubscriptionFullDTO, EmployeeSouscriptionRepository> implements IEmployeeSubscriptionService {

    @Resource(name = ConstsValues.ConstsDAO.EMPLOYEE_SOUSCRIPTION_DAO_KEY)
    private EmployeeSouscriptionRepository employeeSouscriptionRepository;

    @Resource(name = ConstsValues.ConstsDAO.EMPLOYEE_DAO_KEY)
    private EmployeeRepository employeeRepository;

    @Resource(name = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
    private IntraSessionRepository intraSessionRepository;

    public EmployeeSubscriptionServiceImpl() {
        super(EmployeeSubscription.class, EmployeeSubscriptionBasicDTO.class, EmployeeSubscriptionFullDTO.class);
    }

    @Override
    public EmployeeSouscriptionRepository getDAO() {
        return this.employeeSouscriptionRepository;
    }

    @Override
    public IntraSessionFullDTO create(Integer intraSessionId, List<Integer> employeesId) throws AkdemiaBusinessException {
        IntraSession intraSession = intraSessionRepository.findById(intraSessionId).orElse(null);
        if (intraSession == null) throw new AkdemiaBusinessException("La session n'existe pas");
        employeesId.forEach((id) -> {
            Employee employee = employeeRepository.findById(id).orElse(null);
            EmployeeSubscription employeeSubscription = new EmployeeSubscription();
            if (employee != null) {
                employeeSubscription.setEmployee(employee);
                employeeSubscription.setStatus(Status.OPEN);
                employeeSubscription.setIntraSession(intraSession);
                employeeSouscriptionRepository.save(employeeSubscription);
            }
        });
        return getModelMapper().map(intraSession, IntraSessionFullDTO.class);
    }

    @Override
    public void deleteAfterVerification(Integer subscriptionId) throws AkdemiaBusinessException {

        Employee employee = employeeRepository.findById(1).orElse(null);
        if (employee == null) {
            throw new AkdemiaBusinessException("L'employé n'existe pas");
        }

        IntraSession session = intraSessionRepository.findById(1).orElse(null);
        if (session == null) {
            throw new AkdemiaBusinessException("La session n'existe pas");
        }

        Date today = new Date();
        LocalDate todayLocalDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate sessionLocalDate = session.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long difference = ChronoUnit.DAYS.between(todayLocalDate, sessionLocalDate);
        if (difference < 15) {
            throw new AkdemiaBusinessException("la date de début est proche de moin de 15 jours");
        }

        List<EmployeeSubscription> employeeSubscriptions = employeeSouscriptionRepository.findAll();

        employeeSubscriptions.forEach((subscription) -> {
            Integer subscriptionEmployeeId = subscription.getEmployee().getId();
            Integer subscriptionIntraSessionId = subscription.getIntraSession().getId();
            if (subscriptionEmployeeId.equals(1) && subscriptionIntraSessionId.equals(1)) getDAO().delete(subscription);
        });
    }
}
