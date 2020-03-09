package adventurexp.demo;

import adventurexp.demo.model.Booking;

import java.util.List;

public interface BookingInterface {

    List<Booking> getAllBookings();

    Booking findBookingById(int bookingId);

    int addBooking(Booking booking);

    int updateBooking(Booking booking);

    int deleteBooking(int bookingId);
}
