package adventurexp.demo.controller.frontoffice;

import adventurexp.demo.model.Activity;
import adventurexp.demo.model.Booking;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrivateCustomersController {

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Autowired
    ActivityService activityService;

    //-------------------------------PRIVATE BOOKING-------------------------------
    @GetMapping("/privatebook")
    public String getPrivatebook(Model model){
        List<Activity> activities = new ArrayList<>();
        Booking booking = new Booking();
        model.addAttribute("activitiesList",activities);
        model.addAttribute("booking", booking);

        return "booking";
    }

    @PostMapping("/privatebook")
    public String postPrivatebook(@RequestParam int actitivtyId, @ModelAttribute Booking booking) {
        Activity activity = activityService.findAcitivityById(actitivtyId);
        booking.setActivityId(activity.getActitivtyId());
        booking.setBookingType(0);
        bookingService.addBooking(booking);

        return "redirect:/";
    }
}
