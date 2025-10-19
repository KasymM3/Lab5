package kz.lab5.lab5.Service;

import kz.lab5.lab5.Entity.ApplicationRequest;
import kz.lab5.lab5.Entity.Operators;
import kz.lab5.lab5.Repository.AppRequestRepository;
import kz.lab5.lab5.Repository.OperatorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperatorsService {

    private final OperatorsRepository operatorsRepository;
    private final AppRequestService appRequestService;

    public List<Operators> findAll(){
        return operatorsRepository.findAll();
    }

    public void assignOperators(Long id, List<Long> ids){
        ApplicationRequest applicationRequest = appRequestService.findById(id);
        List<Operators> selected = operatorsRepository.findAllById(ids);
        applicationRequest.setOperators(selected);
        appRequestService.save(applicationRequest);
    }

    public void deleteById(Long regId, Long opId){
        ApplicationRequest applicationRequest = appRequestService.findById(regId);
        Operators operators = operatorsRepository.findById(opId).orElse(null);
        applicationRequest.getOperators().remove(operators);
        appRequestService.save(applicationRequest);
    }

}
