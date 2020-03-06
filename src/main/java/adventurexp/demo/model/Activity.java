package adventurexp.demo.model;

public class Activity {

    private int actitivtyId;
    private String name;
    private int ageLimit;
    private double price;
    private double discount;
    private int participants;
    private int minSlots;
    private int maxSlots;
    private String instructor;
    private String date;

    public Activity() {
    }

    public Activity(int actitivtyId, String name, int ageLimit, double price,
                    double discount, int participants, int minSlots, int maxSlots, String instructor, String date) {
        this.actitivtyId = actitivtyId;
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.discount = discount;
        this.participants = participants;
        this.minSlots = minSlots;
        this.maxSlots = maxSlots;
        this.instructor = instructor;
        this.date = date;
    }
    public Activity(int actitivtyId, String name, int ageLimit, double price,
                    int participants, int minSlots, int maxSlots, String instructor, String date) {
        this.actitivtyId = actitivtyId;
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.participants = participants;
        this.minSlots = minSlots;
        this.maxSlots = maxSlots;
        this.instructor = instructor;
        this.date = date;
    }

    public int getActitivtyId() {
        return actitivtyId;
    }

    public void setActitivtyId(int actitivtyId) {
        this.actitivtyId = actitivtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getMinSlots() {
        return minSlots;
    }

    public void setMinSlots(int minSlots) {
        this.minSlots = minSlots;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "actitivtyId=" + actitivtyId +
                ", name='" + name + '\'' +
                ", ageLimit=" + ageLimit +
                ", price=" + price +
                ", discount=" + discount +
                ", participants=" + participants +
                ", minSlots=" + minSlots +
                ", maxSlots=" + maxSlots +
                ", instructor='" + instructor + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
