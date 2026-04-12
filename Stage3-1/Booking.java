//Kobe Smith on 4/6/2026

public class Booking {
    private String bookingStatus;

    public Booking() {
        this.bookingStatus = "Pending";
    }

    public void updateBookingStatus(String newStatus) {
        this.bookingStatus = newStatus;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }
}