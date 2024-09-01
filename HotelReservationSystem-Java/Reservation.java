import java.util.Date;

public class Reservation {
    private Room room;
    private String customerName;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Room room, String customerName, Date checkInDate, Date checkOutDate) {
        this.room = room;
        this.customerName = customerName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation [Room=" + room + ", Customer Name=" + customerName +
                ", Check-In=" + checkInDate + ", Check-Out=" + checkOutDate + "]";
    }
}
