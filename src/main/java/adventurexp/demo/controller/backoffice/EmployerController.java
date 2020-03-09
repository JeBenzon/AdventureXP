package adventurexp.demo.controller.backoffice;

import adventurexp.demo.model.Activity;
import adventurexp.demo.model.Booking;
import adventurexp.demo.model.User;
import adventurexp.demo.service.ActivityService;
import adventurexp.demo.service.BookingService;
import adventurexp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class EmployerController {

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Autowired
    ActivityService activityService;

    //-------------------------------LOGIN-------------------------------
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

    //-------------------------------CONTROL PANEL-------------------------------
    @GetMapping("/controlpanel")
    public String controlpanel(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);

        return "controlpanel";
    }

    //-------------------------------EDIT BOOKING-------------------------------
    @GetMapping("/editbooking")
    public String editbooking(Model model /*@RequestParam int bookingId*/) {
        Booking booking = bookingService.findBookingById(1);
        model.addAttribute("booking", booking);

        return "editBooking";
    }

    @PostMapping("/editBooking")
    public String updateBooking(@ModelAttribute Booking booking) {
        bookingService.updateBooking(booking);
        return "redirect:/";
    }

    //-------------------------------DELETE BOOKING-------------------------------
    @PostMapping("/deletebooking")
    public String deletebooking(@RequestParam int bookingId) {
        bookingService.deleteBooking(bookingId);
        return "redirect:/";
    }

    //-------------------------------CREATE ACTIVITY-------------------------------
    @GetMapping("/createactivity")
    public String createActivity(Model model) {
        Activity activity = new Activity();
        model.addAttribute("activity", activity);
        return "createActivity";
    }

    @PostMapping("/createActivity")
    public String createActivity(@ModelAttribute Activity activity) {
        activityService.addActivity(activity);
        return "redirect:/";
    }
}
