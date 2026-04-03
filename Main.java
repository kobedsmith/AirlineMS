//Kobe Smith on 4/1/2026
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create some sample data for the airline system
        ArrayList<Aircraft> aircraftList = new ArrayList<>();
        AircraftManager aircraftManager = new AircraftManager("Kobe Smith", 40, 1001, "kobe.smith@airline.com", "123456789", "Aircraft Management", aircraftList);

        ArrayList<Ticket> ticketList = new ArrayList<>();
        TicketManager ticketManager = new TicketManager("John Doe", 35, 1002, "john.doe@airline.com", "987654321", "Ticket Management", ticketList);

        ArrayList<Staff> totalStaff = new ArrayList<>();
        ArrayList<Staff> managers = new ArrayList<>();
        ArrayList<Staff> cockpit = new ArrayList<>();
        ArrayList<Staff> attendants = new ArrayList<>();
        HumanResources humanResources = new HumanResources(totalStaff, managers, cockpit, attendants, "Human Resources", "Jane Smith", 1000, "jane.smith@airline.com", "000000000");

        // Add some aircraft to the fleet
        Aircraft aircraft1 = new Aircraft("#737", "Boeing 737", 150, 15);
        Aircraft aircraft2 = new Aircraft("#320", "Airbus A320", 180, 20);
        aircraftManager.addAircraft(aircraft1);
        aircraftManager.addAircraft(aircraft2);

        // Add some tickets to the system
        Ticket ticket1 = new Ticket("Economy", 600.0);
        Ticket ticket2 = new Ticket("Premium Economy", 720.0);
        Ticket ticket3 = new Ticket("Business Class", 900.0);
        Ticket ticket4 = new Ticket("First Class", 1200.0);
        ticketManager.addTicket(ticket1);
        ticketManager.addTicket(ticket2);
        ticketManager.addTicket(ticket3);
        ticketManager.addTicket(ticket4);

        ArrayList<Staff> staffOnBoard = new ArrayList<>();
        ArrayList<Passenger> passengerList = new ArrayList<>();
        ArrayList<Flight> flightList = new ArrayList<>();
        // Hire some staff members
        Staff manager1 = new AircraftManager("Rone Smith", 45, 1003, "rone.smith@airline.com", "555555555", "Aircraft Management", aircraftList);
        Staff manager2 = new FlightManager("Alice Johnson", 38, 1004, "alice.johnson@airline.com", "666666666", "Flight Management", flightList, passengerList, staffOnBoard);
        Staff manager3 = new PaymentProcessor("Bob Wilson", 42, 1005, "bob.wilson@airline.com", "777777777", "Payment Processing");
        Staff manager4 = new TicketManager("Carol Brown", 33, 1006, "carol.brown@airline.com", "888888888", "Ticket Management", ticketList);
        humanResources.hireManager(manager1);
        humanResources.hireManager(manager2);
        humanResources.hireManager(manager3);
        humanResources.hireManager(manager4);
        Staff staff1 = new CockpitCrew("John Doe", 26, 12345, "john.doe@airline.com", "111111111", "Cockpit Crew", 250000);
        Staff staff2 = new FlightAttendants("Jane Smith", 28, 67890, "jane.smith@airline.com", "222222222", "Flight Attendants", 100000);
        humanResources.hireStaff(staff1);
        humanResources.hireStaff(staff2);

        // Create an airline and display its information
        Airline airline = new Airline("SkyHigh Airlines", "New York");
        System.out.println("Airline Name: " + airline.getName());
        System.out.println("Headquarters: " + airline.getHeadquarters());
        airline.getFlightManager(manager2);
        airline.getAircraftManager(manager1);
        airline.getHumanResources(humanResources);
        airline.getPaymentProcessor(manager3);
        aircraftManager.displayFleet();
        humanResources.displayStaff(airline);
        airline.displayInformation();
    }
}