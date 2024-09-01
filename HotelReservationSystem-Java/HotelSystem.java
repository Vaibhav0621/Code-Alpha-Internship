import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        // Initialize with some rooms
        rooms.add(new Room("101", "Single", 100.0, true));
        rooms.add(new Room("102", "Double", 150.0, true));
        rooms.add(new Room("103", "Suite", 250.0, true));
    }

    public List<Room> searchAvailableRooms(String roomType) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean makeReservation(String roomNumber, String customerName, Date checkIn, Date checkOut) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && room.isAvailable()) {
                room.setAvailable(false);
                Reservation reservation = new Reservation(room, customerName, checkIn, checkOut);
                reservations.add(reservation);
                System.out.println("Reservation successful: " + reservation);
                return true;
            }
        }
        System.out.println("Room not available or invalid room number.");
        return false;
    }

    public void viewReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
