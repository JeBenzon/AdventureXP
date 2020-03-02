package adventurexp.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HtmlTestController {

    @GetMapping("/htmltest")
    public String htmlTest(){
        return "TestPage";
    }
}
