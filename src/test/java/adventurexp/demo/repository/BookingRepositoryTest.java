package adventurexp.demo.repository;

import adventurexp.demo.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {

    @Autowired
    BookingRepository bookingRepository;

    @Test
    void getAllBookings1() {
        List<Booking> bookings = bookingRepository.getAllBookings();
        assertEquals(1, bookings.size());
    }

    @Test
    void findBookingById1() {
    }

    @Test
    void addBooking1() {
    }

    @Test
    void updateBooking() {
    }

    @Test
    void deleteBooking() {
    }
}