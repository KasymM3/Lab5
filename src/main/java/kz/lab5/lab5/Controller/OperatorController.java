package kz.lab5.lab5.Controller;

import kz.lab5.lab5.Service.OperatorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OperatorController {
    private final OperatorsService operatorsService;

    @PostMapping("/assign/{id}")
    public String operator(@PathVariable Long id, @RequestParam("ids")List<Long> ids){
        operatorsService.assignOperators(id,ids);
        return "redirect:/details/{id}";
    }

    @PostMapping("/requests/{redId}/operators/{opId}/delete")
    public String delete_operator(@PathVariable Long redId, @PathVariable Long opId){
        operatorsService.deleteById(redId,opId);
        return "redirect:/details/{redId}";
    }
}
