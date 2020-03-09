package adventurexp.demo.controller.backoffice;

import adventurexp.demo.model.Activity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActivityController {

    @GetMapping("/createActivity")
    public String addActivity(Model model){
        model.addAttribute("activity", new Activity());
        return "createActivity";
    }
}
