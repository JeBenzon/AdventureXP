package adventurexp.demo.service;

import adventurexp.demo.BookingInterface;
import adventurexp.demo.model.Booking;
import adventurexp.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingInterface {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return null;
    }

    @Override
    public Booking findBookingById(int bookingId) {
        return bookingRepository.findBookingById(bookingId);
    }

    @Override
    public int addBooking(Booking booking) {
        return 0;
    }

    @Override
    public int updateBooking(Booking booking) {
        return 0;
    }

    @Override
    public int deleteBooking(int bookingId) {
        return 0;
    }
}
