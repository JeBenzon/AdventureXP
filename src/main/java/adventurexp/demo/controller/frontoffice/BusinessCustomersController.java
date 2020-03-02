package adventurexp.demo.controller.frontoffice;

import adventurexp.demo.model.Activity;
import adventurexp.demo.model.Booking;
import adventurexp.demo.model.User;
import adventurexp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BusinessCustomersController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User loginToken, HttpSession session) {
        User user = userService.validateUser(loginToken);
        if(user != null) {
            session.setAttribute("user", user);
            return "/controlpanel";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/privatebook")
    public String getPrivatebook(Model model){
        List<Activity> activities = new ArrayList<>();
        Booking booking = new Booking();
        model.addAttribute("activitiesList",activities);
        model.addAttribute("booking", booking);

        return "privatebook";
    }

    @PostMapping("/privatebook")
    public String postPrivatebook(@RequestParam int actitivtyId, @ModelAttribute Booking booking) {
        Activity activity = metode.findActiviyId;
        booking.setActivityId(activity.getActitivtyId());
        booking.setBookingType("Private");
        bookingService.addBooking(booking);

        return "redirect:/";
    }

    @GetMapping("/businessbook")
    public String getBusinessbook(Model model){
        List<Activity> activities = new ArrayList<>();
        Booking booking = new Booking();
        model.addAttribute("activitiesList",activities);
        model.addAttribute("booking", booking);

        return "businessbook";
    }

    @PostMapping("/businessbook")
    public String postBusinessbook(@RequestParam int actitivtyId, @ModelAttribute Booking booking) {
        Activity activity = metode.findActiviyId;
        booking.setActivityId(activity.getActitivtyId());
        booking.setBookingType("Business");
        bookingService.addBooking(booking);

        return "redirect:/";
    }

    @GetMapping("/controlpanel")
    public String controlpanel(Model model, HttpSession session) {
        User user = session.getAttribute("user");
        model.addAttribute("user", user);

        return "controlpanel";
    }

    @GetMapping("/editbooking")
    public String editbooking() {

    }

    @GetMapping("/deletebooking")
    public String deletebooking() {

    }

    public String("createactivity") {

    }


}
