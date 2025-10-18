package kz.lab5.lab5.Controller;


import kz.lab5.lab5.Entity.ApplicationRequest;
import kz.lab5.lab5.Service.AppRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppRequestController {

    private final AppRequestService appRequestService;

    @Autowired
    public AppRequestController(AppRequestService appRequestService) {
        this.appRequestService = appRequestService;
    }

    @GetMapping("/")
    public String allRequests(Model model){
        List<ApplicationRequest> requestList = appRequestService.findAll();
        model.addAttribute("requests",requestList);
        return "all_request";
    }

    @GetMapping("/new-requests")
    public String newRequests(Model model){
        model.addAttribute("requests",appRequestService.findByHandledFalse());
        return "new_request";
    }

    @GetMapping("/processed-requests")
    public String processedRequests(Model model){
        model.addAttribute("requests",appRequestService.findByHandledTrue());
        return "processed_requests";
    }

    @GetMapping("/new")
    public String addApp(Model model){
        model.addAttribute("request", new ApplicationRequest());
        return "add";
    }

    @PostMapping("/add")
    public String addNew(@ModelAttribute ApplicationRequest applicationRequest){
        appRequestService.add(applicationRequest);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        ApplicationRequest applicationRequest = appRequestService.findById(id);
        model.addAttribute("request",applicationRequest);
        return "details";
    }

    @PostMapping("/details/{id}")
    public String edit(@ModelAttribute ApplicationRequest applicationRequest){
        appRequestService.save(applicationRequest);
        return "redirect:/";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        appRequestService.deleteById(id);
        return "redirect:/";
    }
}
