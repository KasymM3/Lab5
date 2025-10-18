package kz.lab5.lab5.Service;


import kz.lab5.lab5.Entity.ApplicationRequest;
import kz.lab5.lab5.Repository.AppRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRequestService {

    private final AppRequestRepository appRequestRepository;

    @Autowired
    public AppRequestService(AppRequestRepository appRequestRepository) {
        this.appRequestRepository = appRequestRepository;
    }

    public List<ApplicationRequest> findAll(){
        return appRequestRepository.findAll();
    }

    public List<ApplicationRequest> findByHandledFalse(){
        return appRequestRepository.findByHandled(false);
    }
    public List<ApplicationRequest> findByHandledTrue(){
        return appRequestRepository.findByHandled(true);
    }

    public void add(ApplicationRequest applicationRequest){
        applicationRequest.setHandled(false);
        appRequestRepository.save(applicationRequest);
    }

    public void save(ApplicationRequest applicationRequest){
        applicationRequest.setHandled(true);
        appRequestRepository.save(applicationRequest);
    }

    public ApplicationRequest findById(Long id){
        return appRequestRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        appRequestRepository.deleteById(id);
    }
}
