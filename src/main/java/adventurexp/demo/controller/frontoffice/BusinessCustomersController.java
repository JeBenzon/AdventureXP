package adventurexp.demo.controller.frontoffice;

import adventurexp.demo.model.Activity;
import adventurexp.demo.model.Booking;
import adventurexp.demo.model.User;
import adventurexp.demo.service.ActivityService;
import adventurexp.demo.service.BookingService;
import adventurexp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BusinessCustomersController {

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Autowired
    ActivityService activityService;

    //-------------------------------BUSINESS BOOKING-------------------------------
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
        Activity activity = activityService.findAcitivityById(actitivtyId);
        booking.setActivityId(activity.getActitivtyId());
        booking.setBookingType(1);
        bookingService.addBooking(booking);

        return "redirect:/";
    }
}
