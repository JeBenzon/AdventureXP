package adventurexp.demo.controller;

import adventurexp.demo.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookingService bookingService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
