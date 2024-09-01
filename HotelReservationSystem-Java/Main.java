import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelSystem hotelSystem = new HotelSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1. Search Rooms");
                System.out.println("2. Make Reservation");
                System.out.println("3. View Reservations");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                    continue; // Restart the loop
                }

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter room type (Single/Double/Suite): ");
                        String roomType = scanner.next();
                        List<Room> availableRooms = hotelSystem.searchAvailableRooms(roomType);
                        if (availableRooms.isEmpty()) {
                            System.out.println("No available rooms.");
                        } else {
                            for (Room room : availableRooms) {
                                System.out.println(room);
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Enter room number: ");
                        String roomNumber = scanner.next();
                        System.out.print("Enter your name: ");
                        String customerName = scanner.next();
                        // Mock check-in and check-out dates
                        Date checkIn = new Date();
                        Date checkOut = new Date(checkIn.getTime() + (1000 * 60 * 60 * 24)); // Next day
                        hotelSystem.makeReservation(roomNumber, customerName, checkIn, checkOut);
                        break;
                    case 3:
                        hotelSystem.viewReservations();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
}
