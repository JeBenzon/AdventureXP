package adventurexp.demo.model;

public class Booking {

    private int bookingId;
    private String bookingType;
    private int activityId;
    private String name;
    private int participants;
    private String date;

    public Booking() {
    }

    public Booking(int bookingId, String bookingType, int activityId, String name, int participants, String date) {
        this.bookingId = bookingId;
        this.bookingType = bookingType;
        this.activityId = activityId;
        this.name = name;
        this.participants = participants;
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", activityId=" + activityId +
                ", name='" + name + '\'' +
                ", participants=" + participants +
                ", date='" + date + '\'' +
                '}';
    }
}
