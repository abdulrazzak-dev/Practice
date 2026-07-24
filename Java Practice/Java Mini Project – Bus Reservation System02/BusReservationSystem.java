import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ==========================================
// ENTITY 1: BUS CLASS
// ==========================================
class Bus {
    private String busNumber;
    private String source;
    private String destination;
    private int capacity;
    private int bookedSeats;

    public Bus(String busNumber, String source, String destination, int capacity) {
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = 0; // Initialized to 0
    }

    // Getters and Setters
    public String getBusNumber() {
        return busNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Business Logic Methods
    public boolean bookSeat() {
        if (getAvailableSeats() > 0) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    public boolean cancelSeat() {
        if (bookedSeats > 0) {
            bookedSeats--;
            return true;
        }
        return false;
    }

    public void displayBusDetails() {
        System.out.printf("| %-10s | %-15s | %-15s | %-8d | %-12d | %-15d |\n",
                busNumber, source, destination, capacity, bookedSeats, getAvailableSeats());
    }
}

// ==========================================
// ENTITY 2: BOOKING CLASS
// ==========================================
class Booking {
    private String passengerId;
    private String passengerName;
    private Bus bus;

    public Booking(String passengerId, String passengerName, Bus bus) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.bus = bus;
    }

    // Getters
    public String getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Bus getBus() {
        return bus;
    }

    public void displayBookingDetails() {
        System.out.printf("| %-12s | %-20s | %-10s | %-15s | %-15s |\n",
                passengerId, passengerName, bus.getBusNumber(), bus.getSource(), bus.getDestination());
    }
}

// ==========================================
// MAIN APPLICATION (MODULES 1 TO 5)
// ==========================================
public class BusReservationSystem {
    private static List<Bus> busList = new ArrayList<>();
    private static List<Booking> bookingList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample data for quick testing
        busList.add(new Bus("B101", "Colombo", "Kandy", 30));
        busList.add(new Bus("B102", "Galle", "Colombo", 25));

        int choice;
        do {
            displayMainMenu();
            choice = getIntInput("Enter your choice (1-9): ");
            System.out.println();

            switch (choice) {
                // MODULE 01: BUS MANAGEMENT
                case 1 -> addBus();
                case 2 -> viewAllBuses();
                case 3 -> updateBusCapacity();
                case 4 -> deleteBus();
                case 5 -> searchBus();
                
                // MODULE 02: TICKET BOOKING
                case 6 -> bookTicket();
                
                // MODULE 03: VIEW BOOKINGS
                case 7 -> viewAllBookings();
                
                // MODULE 04: CANCEL BOOKING
                case 8 -> cancelBooking();
                
                // MODULE 05: EXIT APPLICATION
                case 9 -> System.out.println("Thank you for using the Bus Reservation System. Goodbye!");
                
                default -> System.out.println("Error: Invalid choice! Please select an option between 1 and 9.");
            }
            System.out.println();
        } while (choice != 9);

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("==================================================");
        System.out.println("            BUS RESERVATION SYSTEM                ");
        System.out.println("==================================================");
        System.out.println("--- Module 01: Bus Management ---");
        System.out.println("1. Add New Bus");
        System.out.println("2. View All Available Buses");
        System.out.println("3. Update Bus Capacity");
        System.out.println("4. Delete Bus");
        System.out.println("5. Search Bus by Number");
        System.out.println("--- Module 02: Ticket Booking ---");
        System.out.println("6. Book Ticket");
        System.out.println("--- Module 03: View Bookings ---");
        System.out.println("7. View All Bookings");
        System.out.println("--- Module 04: Cancel Booking ---");
        System.out.println("8. Cancel Booking");
        System.out.println("--- Module 05: Exit ---");
        System.out.println("9. Exit Application");
        System.out.println("==================================================");
    }

    // ==========================================
    // MODULE 01: BUS MANAGEMENT
    // ==========================================

    private static void addBus() {
        System.out.println("--- [Module 01] Add New Bus ---");
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine().trim();

        if (findBusByNumber(busNumber) != null) {
            System.out.println("Error: Bus with number " + busNumber + " already exists!");
            return;
        }

        System.out.print("Enter Source: ");
        String source = scanner.nextLine().trim();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine().trim();

        int capacity = getIntInput("Enter Total Seating Capacity: ");

        busList.add(new Bus(busNumber, source, destination, capacity));
        System.out.println("Success: Bus " + busNumber + " added successfully!");
    }

    private static void viewAllBuses() {
        System.out.println("--- [Module 01] Available Buses ---");
        if (busList.isEmpty()) {
            System.out.println("No buses currently registered in the system.");
            return;
        }

        printTableLine(88);
        System.out.printf("| %-10s | %-15s | %-15s | %-8s | %-12s | %-15s |\n",
                "Bus No.", "Source", "Destination", "Capacity", "Booked Seats", "Available Seats");
        printTableLine(88);

        for (Bus bus : busList) {
            bus.displayBusDetails();
        }
        printTableLine(88);
    }

    private static void updateBusCapacity() {
        System.out.println("--- [Module 01] Update Bus Capacity ---");
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine().trim();

        Bus bus = findBusByNumber(busNumber);
        if (bus == null) {
            System.out.println("Error: Bus with number " + busNumber + " not found!");
            return;
        }

        int newCapacity = getIntInput("Enter New Capacity: ");
        if (newCapacity < bus.getBookedSeats()) {
            System.out.println("Error: Cannot set capacity lower than already booked seats (" + bus.getBookedSeats() + ").");
            return;
        }

        bus.setCapacity(newCapacity);
        System.out.println("Success: Capacity for Bus " + busNumber + " updated to " + newCapacity + ".");
    }

    private static void deleteBus() {
        System.out.println("--- [Module 01] Delete Bus ---");
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine().trim();

        Bus bus = findBusByNumber(busNumber);
        if (bus == null) {
            System.out.println("Error: Bus with number " + busNumber + " not found!");
            return;
        }

        // Prevent deletion if passenger bookings exist
        boolean hasBookings = bookingList.stream().anyMatch(b -> b.getBus().getBusNumber().equalsIgnoreCase(busNumber));
        if (hasBookings) {
            System.out.println("Error: Cannot delete bus! Active passenger bookings exist for this bus.");
            return;
        }

        busList.remove(bus);
        System.out.println("Success: Bus " + busNumber + " deleted successfully!");
    }

    private static void searchBus() {
        System.out.println("--- [Module 01] Search Bus ---");
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine().trim();

        Bus bus = findBusByNumber(busNumber);
        if (bus == null) {
            System.out.println("Error: Bus with number " + busNumber + " not found!");
            return;
        }

        printTableLine(88);
        System.out.printf("| %-10s | %-15s | %-15s | %-8s | %-12s | %-15s |\n",
                "Bus No.", "Source", "Destination", "Capacity", "Booked Seats", "Available Seats");
        printTableLine(88);
        bus.displayBusDetails();
        printTableLine(88);
    }

    // ==========================================
    // MODULE 02: TICKET BOOKING
    // ==========================================

    private static void bookTicket() {
        System.out.println("--- [Module 02] Book Ticket ---");
        if (busList.isEmpty()) {
            System.out.println("No buses available for booking.");
            return;
        }

        System.out.print("Enter Passenger ID: ");
        String passengerId = scanner.nextLine().trim();

        // Validation: Ensure Unique Passenger ID
        if (findBookingByPassengerId(passengerId) != null) {
            System.out.println("Error: Passenger ID " + passengerId + " already exists! Passenger ID must be unique.");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        String passengerName = scanner.nextLine().trim();

        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine().trim();

        Bus bus = findBusByNumber(busNumber);
        if (bus == null) {
            System.out.println("Error: Bus with number " + busNumber + " does not exist!");
            return;
        }

        // Validation: Check seat availability
        if (bus.getAvailableSeats() <= 0) {
            System.out.println("Error: Booking failed! Bus " + busNumber + " has no available seats.");
            return;
        }

        // Book seat and update count
        if (bus.bookSeat()) {
            Booking booking = new Booking(passengerId, passengerName, bus);
            bookingList.add(booking);
            System.out.println("Success: Ticket booked successfully for " + passengerName + " on Bus " + busNumber + "!");
        }
    }

    // ==========================================
    // MODULE 03: VIEW BOOKINGS
    // ==========================================

    private static void viewAllBookings() {
        System.out.println("--- [Module 03] View All Bookings ---");
        if (bookingList.isEmpty()) {
            System.out.println("No booking records found.");
            return;
        }

        printTableLine(84);
        System.out.printf("| %-12s | %-20s | %-10s | %-15s | %-15s |\n",
                "Passenger ID", "Passenger Name", "Bus No.", "Source", "Destination");
        printTableLine(84);

        for (Booking booking : bookingList) {
            booking.displayBookingDetails();
        }
        printTableLine(84);
    }

    // ==========================================
    // MODULE 04: CANCEL BOOKING
    // ==========================================

    private static void cancelBooking() {
        System.out.println("--- [Module 04] Cancel Booking ---");
        System.out.print("Enter Passenger ID: ");
        String passengerId = scanner.nextLine().trim();

        Booking booking = findBookingByPassengerId(passengerId);
        if (booking == null) {
            System.out.println("Error: Booking verification failed! No booking found for Passenger ID: " + passengerId);
            return;
        }

        // Release booked seat on the associated bus
        Bus bus = booking.getBus();
        bus.cancelSeat();

        bookingList.remove(booking);
        System.out.println("Success: Booking cancelled successfully for Passenger ID: " + passengerId);
    }

    // ==========================================
    // HELPER & VALIDATION METHODS
    // ==========================================

    private static Bus findBusByNumber(String busNumber) {
        for (Bus bus : busList) {
            if (bus.getBusNumber().equalsIgnoreCase(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    private static Booking findBookingByPassengerId(String passengerId) {
        for (Booking booking : bookingList) {
            if (booking.getPassengerId().equalsIgnoreCase(passengerId)) {
                return booking;
            }
        }
        return null;
    }

    private static int getIntInput(String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            try {
                number = Integer.parseInt(scanner.nextLine().trim());
                if (number <= 0) {
                    System.out.println("Error: Input must be greater than zero.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a valid number.");
            }
        }
        return number;
    }

    private static void printTableLine(int length) {
        System.out.println("-".repeat(length));
    }
}