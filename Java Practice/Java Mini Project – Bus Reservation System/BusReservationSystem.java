import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing a Bus entity
class Bus {
    private int busId;
    private String busName;
    private String route;
    private int totalCapacity;
    private int availableSeats;

    public Bus(int busId, String busName, String route, int totalCapacity) {
        this.busId = busId;
        this.busName = busName;
        this.route = route;
        this.totalCapacity = totalCapacity;
        this.availableSeats = totalCapacity;
    }

    // Getters and Setters
    public int getBusId() { return busId; }
    public String getBusName() { return busName; }
    public String getRoute() { return route; }
    public int getTotalCapacity() { return totalCapacity; }
    public int getAvailableSeats() { return availableSeats; }

    public void setTotalCapacity(int newCapacity) {
        int seatsBooked = this.totalCapacity - this.availableSeats;
        if (newCapacity < seatsBooked) {
            System.out.println("Error: Cannot set capacity lower than already booked seats (" + seatsBooked + ").");
            return;
        }
        this.totalCapacity = newCapacity;
        this.availableSeats = newCapacity - seatsBooked;
        System.out.println("Success: Bus capacity updated to " + newCapacity);
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < totalCapacity) {
            availableSeats++;
        }
    }

    public void displayBusInfo() {
        System.out.printf("| %-8d | %-15s | %-20s | %-14d | %-15d |\n", 
                busId, busName, route, totalCapacity, availableSeats);
    }
}

// Class representing a Booking record
class Booking {
    private static int bookingIdCounter = 101;
    private int bookingId;
    private String passengerName;
    private int busId;

    public Booking(String passengerName, int busId) {
        this.bookingId = bookingIdCounter++;
        this.passengerName = passengerName;
        this.busId = busId;
    }

    public int getBookingId() { return bookingId; }
    public String getPassengerName() { return passengerName; }
    public int getBusId() { return busId; }

    public void displayBookingInfo() {
        System.out.printf("| %-10d | %-20s | %-8d |\n", bookingId, passengerName, busId);
    }
}

// Main System and Controller
public class BusReservationSystem {
    private static List<Bus> busList = new ArrayList<>();
    private static List<Booking> bookingList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populating dummy data for immediate testing
        busList.add(new Bus(1, "Express AC", "City A -> City B", 30));
        busList.add(new Bus(2, "Luxury Sleeper", "City C -> City D", 20));

        int choice;
        do {
            displayMenu();
            choice = getIntInput("Enter your choice (1-8): ");
            System.out.println();

            switch (choice) {
                case 1 -> addBus();
                case 2 -> viewAllBuses();
                case 3 -> updateBusCapacity();
                case 4 -> deleteBus();
                case 5 -> bookTicket();
                case 6 -> viewAllBookings();
                case 7 -> cancelBooking();
                case 8 -> System.out.println("Thank you for using the Bus Reservation System. Goodbye!");
                default -> System.out.println("Invalid option! Please enter a number between 1 and 8.");
            }
            System.out.println();
        } while (choice != 8);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("=================================================");
        System.out.println("          BUS RESERVATION SYSTEM MENU            ");
        System.out.println("=================================================");
        System.out.println("1. Add Bus");
        System.out.println("2. View All Buses");
        System.out.println("3. Update Bus Capacity");
        System.out.println("4. Delete Bus");
        System.out.println("5. Book Ticket");
        System.out.println("6. View All Bookings");
        System.out.println("7. Cancel Booking");
        System.out.println("8. Exit");
        System.out.println("=================================================");
    }

    // 1. Add Bus
    private static void addBus() {
        System.out.println("--- Add New Bus ---");
        int busId = getIntInput("Enter Bus ID: ");

        if (findBusById(busId) != null) {
            System.out.println("Error: A bus with ID " + busId + " already exists!");
            return;
        }

        System.out.print("Enter Bus Name: ");
        String busName = scanner.nextLine();

        System.out.print("Enter Route: ");
        String route = scanner.nextLine();

        int capacity = getIntInput("Enter Total Seating Capacity: ");

        busList.add(new Bus(busId, busName, route, capacity));
        System.out.println("Success: Bus added successfully!");
    }

    // 2. View All Buses
    private static void viewAllBuses() {
        System.out.println("--- Available Buses ---");
        if (busList.isEmpty()) {
            System.out.println("No buses currently registered in the system.");
            return;
        }

        printTableLine(73);
        System.out.printf("| %-8s | %-15s | %-20s | %-14s | %-15s |\n", 
                "Bus ID", "Bus Name", "Route", "Total Seats", "Available Seats");
        printTableLine(73);

        for (Bus bus : busList) {
            bus.displayBusInfo();
        }
        printTableLine(73);
    }

    // 3. Update Bus Capacity
    private static void updateBusCapacity() {
        System.out.println("--- Update Bus Capacity ---");
        int busId = getIntInput("Enter Bus ID to update: ");
        Bus bus = findBusById(busId);

        if (bus == null) {
            System.out.println("Error: Bus with ID " + busId + " not found!");
            return;
        }

        int newCapacity = getIntInput("Enter New Capacity: ");
        bus.setTotalCapacity(newCapacity);
    }

    // 4. Delete Bus
    private static void deleteBus() {
        System.out.println("--- Delete Bus ---");
        int busId = getIntInput("Enter Bus ID to delete: ");
        Bus bus = findBusById(busId);

        if (bus == null) {
            System.out.println("Error: Bus with ID " + busId + " not found!");
            return;
        }

        // Check if there are active bookings for this bus
        boolean hasBookings = bookingList.stream().anyMatch(b -> b.getBusId() == busId);
        if (hasBookings) {
            System.out.println("Error: Cannot delete bus! Active bookings exist for this bus.");
            return;
        }

        busList.remove(bus);
        System.out.println("Success: Bus ID " + busId + " deleted successfully!");
    }

    // 5. Book Ticket
    private static void bookTicket() {
        System.out.println("--- Book Ticket ---");
        if (busList.isEmpty()) {
            System.out.println("No buses available for booking.");
            return;
        }

        int busId = getIntInput("Enter Bus ID to book seat: ");
        Bus bus = findBusById(busId);

        if (bus == null) {
            System.out.println("Error: Bus with ID " + busId + " not found!");
            return;
        }

        if (bus.getAvailableSeats() <= 0) {
            System.out.println("Error: Sorry, no seats available on this bus!");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        String passengerName = scanner.nextLine();

        if (bus.bookSeat()) {
            Booking booking = new Booking(passengerName, busId);
            bookingList.add(booking);
            System.out.println("Success: Booking confirmed! Your Booking ID is: " + booking.getBookingId());
        }
    }

    // 6. View All Bookings
    private static void viewAllBookings() {
        System.out.println("--- All Booking Records ---");
        if (bookingList.isEmpty()) {
            System.out.println("No booking records found.");
            return;
        }

        printTableLine(47);
        System.out.printf("| %-10s | %-20s | %-8s |\n", "Booking ID", "Passenger Name", "Bus ID");
        printTableLine(47);

        for (Booking booking : bookingList) {
            booking.displayBookingInfo();
        }
        printTableLine(47);
    }

    // 7. Cancel Booking
    private static void cancelBooking() {
        System.out.println("--- Cancel Booking ---");
        int bookingId = getIntInput("Enter Booking ID to cancel: ");

        Booking foundBooking = null;
        for (Booking booking : bookingList) {
            if (booking.getBookingId() == bookingId) {
                foundBooking = booking;
                break;
            }
        }

        if (foundBooking == null) {
            System.out.println("Error: Booking ID " + bookingId + " not found!");
            return;
        }

        // Restore seat capacity on the respective bus
        Bus bus = findBusById(foundBooking.getBusId());
        if (bus != null) {
            bus.cancelSeat();
        }

        bookingList.remove(foundBooking);
        System.out.println("Success: Booking ID " + bookingId + " has been cancelled.");
    }

    // Helper method to locate a bus by ID
    private static Bus findBusById(int busId) {
        for (Bus bus : busList) {
            if (bus.getBusId() == busId) {
                return bus;
            }
        }
        return null;
    }

    // Helper method for safe integer inputs
    private static int getIntInput(String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number < 0) {
                    System.out.println("Error: Please enter a non-negative number.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
        return number;
    }

    private static void printTableLine(int length) {
        System.out.println("-".repeat(length));
    }
}