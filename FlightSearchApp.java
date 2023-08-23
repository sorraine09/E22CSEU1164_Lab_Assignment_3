import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    String flightID;
    String source;
    String destination;
    double price;

    public Flight(String flightID, String source, String destination, double price) {
        this.flightID = flightID;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }
}

class FlightSearch {
    List<Flight> flights;

    public FlightSearch() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> searchByCity(String city) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.source.equals(city) || flight.destination.equals(city)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }

    public List<Flight> searchBySource(String source) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.source.equals(source)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }

    public List<Flight> searchBetweenCities(String source, String destination) {
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.source.equals(source) && flight.destination.equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
    }
}

public class FlightSearchApp {
    public static void main(String[] args) {
        System.out.println(".......................................................................");


        System.out.println("PRIYANSHU   E22CSEU1164");
        System.out.println(".......................................................................");


        FlightSearch flightSearch = new FlightSearch();

        

        flightSearch.addFlight(new Flight("AI161E90", "BLR", "BOM", 5600));
        flightSearch.addFlight(new Flight("BR161F91", "BOM", "BBI", 6750));
        flightSearch.addFlight(new Flight("AI161F99", "BBI", "BLR", 8210));
        flightSearch.addFlight(new Flight("VS171E20", "JLR", "BBI", 5500));
        flightSearch.addFlight(new Flight("AS171G30", "HYD", "JLR", 4400));
        flightSearch.addFlight(new Flight("AI131F49", "HYD", "BOM", 3499));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search flights for a particular city");
            System.out.println("2. Search flights departing from a city");
            System.out.println("3. Search flights between two given cities");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    List<Flight> matchingFlights = flightSearch.searchByCity(city);
                    displayFlights(matchingFlights);
                    break;
                case "2":
                    System.out.print("Enter source city: ");
                    String source = scanner.nextLine();
                    matchingFlights = flightSearch.searchBySource(source);
                    displayFlights(matchingFlights);
                    break;
                case "3":
                    System.out.print("Enter source city: ");
                    source = scanner.nextLine();
                    System.out.print("Enter destination city: ");
                    String destination = scanner.nextLine();
                    matchingFlights = flightSearch.searchBetweenCities(source, destination);
                    displayFlights(matchingFlights);
                    break;
                case "4":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    public static void displayFlights(List<Flight> flights) {
        if (!flights.isEmpty()) {
            for (Flight flight : flights) {
                System.out.println("Flight ID: " + flight.flightID + ", From: " + flight.source + ", To: " + flight.destination + ", Price: " + flight.price);
            }
        } else {
            System.out.println("No matching flights found.");
        }
    }
}
