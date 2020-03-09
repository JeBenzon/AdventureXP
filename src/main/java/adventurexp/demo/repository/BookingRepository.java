package adventurexp.demo.repository;

import adventurexp.demo.BookingInterface;
import adventurexp.demo.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository implements BookingInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Booking> getAllBookings() {
        return jdbcTemplate.query("SELECT * FROM bookings",
                (rs, rowNum) -> new Booking(
                        rs.getInt("id"),
                        rs.getInt("bookingtype"),
                        rs.getInt("activityId"),
                        rs.getString("name"),
                        rs.getInt("participants"),
                        rs.getString("date")
                ));
    }

    @Override
    public Booking findBookingById(int bookingId) {
        return jdbcTemplate.queryForObject("SELECT * FROM bookings WHERE id = ?", new Object[] {bookingId},
            (rs, rowNum) -> new Booking(
                rs.getInt("id"),
                rs.getInt("bookingtype"),
                rs.getInt("activityId"),
                rs.getString("name"),
                rs.getInt("participants"),
                rs.getString("date")
        ));
    }

    @Override
    public int addBooking(Booking booking) {
        return jdbcTemplate.update("INSERT INTO bookings(id, bookingtype,activityId,name,participants,date) VALUES (?,?,?,?,?,?)",
                booking.getBookingId(), booking.getBookingType(),
                booking.getActivityId(), booking.getName(), booking.getParticipants(), booking.getDate());
    }

    @Override
    public int updateBooking(Booking booking) {
        return jdbcTemplate.update("UPDATE bookings SET bookingtype = ?, activityId = ?, name = ?, participants = ?, date = ?",
        booking.getBookingType(), booking.getActivityId(), booking.getName(), booking.getParticipants(), booking.getDate());
    }

    @Override
    public int deleteBooking(int bookingId) {
        return jdbcTemplate.update("DELETE FROM bookings WHERE id = ?", bookingId);
    }
}
