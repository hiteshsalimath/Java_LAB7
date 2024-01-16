import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Bus {
    private String busNumber;
    private List<Passenger> passengers;

    public Bus(String busNumber) {
        this.busNumber = busNumber;
        this.passengers = new ArrayList<>();
    }

    public String getBusNumber() {
        return busNumber;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}

public class Lab7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Bus> buses = new ArrayList<>(); // Collection Framework - List to store buses

        int choice;

        do {
            System.out.println("\n=== Public Transit System Menu ===");
            System.out.println("1. Add Bus");
            System.out.println("2. Add Passenger to Bus");
            System.out.println("3. Display Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addBus(scanner, buses);
                    break;
                case 2:
                    addPassenger(scanner, buses);
                    break;
                case 3:
                    displayInformation(buses);
                    break;
                case 4:
                    System.out.println("!!Thank you for using our service!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method for adding a bus to the list
    private static void addBus(Scanner scanner, List<Bus> buses) {
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine();
        buses.add(new Bus(busNumber));
        System.out.println("Bus " + busNumber + " added successfully.");
    }

    // Method for adding a passenger to a bus in the list
    private static void addPassenger(Scanner scanner, List<Bus> buses) {
        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine();

        Bus bus = getBus(buses, busNumber);
        if (bus != null) {
            System.out.print("Enter Passenger Name: ");
            String passengerName = scanner.nextLine();
            bus.addPassenger(new Passenger(passengerName));
            System.out.println("Passenger " + passengerName + " added to Bus " + busNumber + " successfully.");
        } else {
            System.out.println("Bus " + busNumber + " not found.");
        }
    }

    // Method for displaying information about buses and passengers
    private static void displayInformation(List<Bus> buses) {
        System.out.println("\n=== Public Transit System Information ===");
        buses.forEach(bus -> {
            System.out.println("Bus " + bus.getBusNumber() + " with passengers:");
            bus.getPassengers().forEach(passenger ->
                    System.out.println("- " + passenger.getName()));
        });
    }

    // Helper method to get a bus from the list by bus number
    private static Bus getBus(List<Bus> buses, String busNumber) {
        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }
}