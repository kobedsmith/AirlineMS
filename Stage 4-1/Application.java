//Kobe Smith on 4/3/2026
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private Airline airline;
    private HumanResources humanResources;
    private AircraftManager aircraftManager;
    private FlightManager flightManager;
    private TicketManager ticketManager;
    private PaymentProcessor paymentProcessor;
    private FlightAttendants flightAttendants;
    private CockpitCrew cockpitCrew;
    private TSA tsa;
    private UserLog userLog;
    private printTicket ticketPrinter;
    private Schedule schedule;
    private Payment payment;
    private Ticket ticket;
    private Flight flight;

    public Application() {
        this.airline = new Airline("SkyHigh Airlines", "New York");
        this.aircraftManager = new AircraftManager("Kobe Smith", 40, 1001, "kobe.smith@airline.com", "376891467", "Aircraft Management", 80000);
        this.humanResources = new HumanResources("Human Resources", "Jane Smith", 1000, "jane.smith@airline.com", "123456888", 150000);
        this.flightManager = new FlightManager("Rone Smith", 38, 1004, "rone.smith@airline.com", "456789123", "Flight Management", 75000);
        this.ticketManager = new TicketManager("John Doe", 35, 1002, "john.doe@airline.com", "987654321", "Ticket Management", 65000);
        this.paymentProcessor = new PaymentProcessor("Bob Wilson", 42, 1005, "bob.wilson@airline.com", "765432109", "Payment Processing", 85000);
        this.flightAttendants = new FlightAttendants();
        this.cockpitCrew = new CockpitCrew();
        this.tsa = new TSA("New York", 25);
        this.userLog = new UserLog();
        this.ticketPrinter = new printTicket();
        this.schedule = new Schedule();
        this.payment = new Payment("", 0.0);
        this.flight = new Flight();
    }

    public void addAircraftManagerToStaff() {
        humanResources.addToStaffList(aircraftManager);
        humanResources.addToManagersList(aircraftManager);
        userLog.addStaff(aircraftManager);
    }

    public void createAircrafts() {
        Aircraft aircraft1 = new Aircraft("#737", "Boeing 737", 150, 15);
        Aircraft aircraft2 = new Aircraft("#320", "Airbus A320", 180, 20);

        aircraftManager.addAircraft(aircraft1);
        aircraftManager.addAircraft(aircraft2);
    }
    

    public void addFlightManagerToStaff() {
        humanResources.addToStaffList(flightManager);
        humanResources.addToManagersList(flightManager);
        userLog.addStaff(flightManager);
    }

    public void addTicketManagerToStaff() {
        humanResources.addToStaffList(ticketManager);
        humanResources.addToManagersList(ticketManager);
        userLog.addStaff(ticketManager);
    }

    public void addPaymentProcessorToStaff() {
        humanResources.addToStaffList(paymentProcessor);
        humanResources.addToManagersList(paymentProcessor);
        userLog.addStaff(paymentProcessor);
    }

    public void createFlights() {
        // Create flights
        Flight flight1 = new Flight("FL1001", "New York", "Los Angeles", "Gate A10", "10:00 AM", "1:00 PM");
        Flight flight2 = new Flight("FL1002", "Los Angeles", "Chicago", "Gate B20", "2:00 PM", "5:00 PM");
        Flight flight3 = new Flight("FL1003", "Chicago", "Miami", "Gate C30", "6:00 PM", "9:00 PM");
        Flight flight4 = new Flight("FL1004", "Miami", "New York", "Gate D40", "10:00 PM", "1:00 AM");

        // Add flights to flight list
        flightManager.addFlight(flight1);
        flightManager.addFlight(flight2);
        flightManager.addFlight(flight3);
        flightManager.addFlight(flight4);

        // Create tickets
        Ticket ticket1 = new Ticket("Economy", "#T101", "N/A", 600.0);
        Ticket ticket2 = new Ticket("Premium", "#T102", "N/A", 960.0);
        Ticket ticket3 = new Ticket("Business", "#T103", "N/A", 2000.0);
        Ticket ticket4 = new Ticket("First Class", "#T104", "N/A", 4500.0);

        // Add tickets to ticket list
        ticketManager.addTicketType(ticket1);
        ticketManager.addTicketType(ticket2);
        ticketManager.addTicketType(ticket3);
        ticketManager.addTicketType(ticket4);

        // Create passengers
        Passenger passenger1 = new Passenger("Emma Payne", "emma.payne@airline.com", "#A1001");
        Passenger passenger2 = new Passenger("Noah John", "noah.john@airline.com", "#A1002");
        Passenger passenger3 = new Passenger("Bruce Wayne", "bruce.wayne@airline.com", "#A1003");
        Passenger passenger4 = new Passenger("Liam Brown", "liam.brown@airline.com", "#A1004");
        Passenger passenger5 = new Passenger("Albert Wesker", "albert.wesker@airline.com", "#A1005");
        Passenger passenger6 = new Passenger("Lucas Wilson", "lucas.wilson@airline.com", "#A1006");
        Passenger passenger7 = new Passenger("Mia Johnson", "mia.johnson@airline.com", "#A1007");
        Passenger passenger8 = new Passenger("Eren Yaeger", "eren.yaeger@airline.com", "#A1008");
        Passenger passenger9 = new Passenger("Gojo Satoru", "gojo.satoru@airline.com", "#A1009");
        Passenger passenger10 = new Passenger("Johnny Bravo", "johnny.bravo@airline.com", "#A1010");
        Passenger p1 = new Passenger("Bruce Banner", "bruce.banner@airline.com", "#A1011");
        Passenger p2 = new Passenger("Clark Kent", "clark.kent@airline.com", "#A1012");
        Passenger p3 = new Passenger("Diana Prince", "diana.prince@airline.com", "#A1013");
        Passenger p4 = new Passenger("Tony Stark", "tony.stark@airline.com", "#A1014");
        Passenger p5 = new Passenger("Steve Rogers", "steve.rogers@airline.com", "#A1015");

        // Add passengers to user log
        userLog.addPassenger(passenger1);
        userLog.addPassenger(passenger2);
        userLog.addPassenger(passenger3);
        userLog.addPassenger(passenger4);
        userLog.addPassenger(passenger5);
        userLog.addPassenger(passenger6);
        userLog.addPassenger(passenger7);
        userLog.addPassenger(passenger8);
        userLog.addPassenger(passenger9);
        userLog.addPassenger(passenger10);
        userLog.addPassenger(p1);
        userLog.addPassenger(p2);
        userLog.addPassenger(p3);
        userLog.addPassenger(p4);
        userLog.addPassenger(p5);

        // Assign passengers to flights
        flightManager.addPassenger(passenger1, flight1);
        flightManager.addPassenger(passenger2, flight2);
        flightManager.addPassenger(passenger3, flight3);
        flightManager.addPassenger(passenger4, flight4);
        flightManager.addPassenger(passenger5, flight1);
        flightManager.addPassenger(passenger6, flight2);
        flightManager.addPassenger(passenger7, flight3);
        flightManager.addPassenger(passenger8, flight4);
        flightManager.addPassenger(passenger9, flight1);
        flightManager.addPassenger(passenger10, flight2);
        flightManager.addPassenger(p1, flight3);
        flightManager.addPassenger(p2, flight4);
        flightManager.addPassenger(p3, flight1);
        flightManager.addPassenger(p4, flight2);
        flightManager.addPassenger(p5, flight3);

        // Assign tickets to passengers
        ticketManager.addPassengerTicket(ticket1, passenger1, flight1.getFlightID());
        ticketManager.addPassengerTicket(ticket2, passenger2, flight2.getFlightID());
        ticketManager.addPassengerTicket(ticket3, passenger3, flight3.getFlightID());
        ticketManager.addPassengerTicket(ticket4, passenger4, flight4.getFlightID());
        ticketManager.addPassengerTicket(ticket1, passenger5, flight1.getFlightID());
        ticketManager.addPassengerTicket(ticket2, passenger6, flight2.getFlightID());
        ticketManager.addPassengerTicket(ticket3, passenger7, flight3.getFlightID());
        ticketManager.addPassengerTicket(ticket4, passenger8, flight4.getFlightID());
        ticketManager.addPassengerTicket(ticket1, passenger9, flight1.getFlightID());
        ticketManager.addPassengerTicket(ticket2, passenger10, flight2.getFlightID());
        ticketManager.addPassengerTicket(ticket3, p1, flight3.getFlightID());
        ticketManager.addPassengerTicket(ticket4, p2, flight4.getFlightID());
        ticketManager.addPassengerTicket(ticket1, p3, flight1.getFlightID());
        ticketManager.addPassengerTicket(ticket2, p4, flight2.getFlightID());
        ticketManager.addPassengerTicket(ticket3, p5, flight3.getFlightID());

        // Create staff members
        Staff s1 = new Staff("Tiare Smith", 30, 1017, "tiare.smith@airline.com", "898989898", "Flight Attendant", 60000);
        Staff s2 = new Staff("Peter Parker", 35, 1018, "peter.parker@airline.com", "909090909", "Flight Attendant", 62000);
        Staff s3 = new Staff("Kyrie Irving", 28, 1019, "kyrie.irving@airline.com", "010101010", "Flight Attendant", 58000);
        Staff s4 = new Staff("Kobe Bryant", 32, 1020, "kobe.bryant@airline.com", "121212121", "Flight Attendant", 65000);
        Staff s5 = new Staff("Kim Dokja", 29, 1021, "kim.dokja@airline.com", "232323232", "Flight Attendant", 61000);
        FlightAttendants attendant1 = new FlightAttendants("Chris Redfield", 29, 1012, "chris.redfield@airline.com", "343434343", "Flight Attendant", 60000);
        FlightAttendants attendant2 = new FlightAttendants("Ethan Winters", 31, 1013, "ethan.winters@airline.com", "454545454", "Flight Attendant", 62000);
        FlightAttendants attendant3 = new FlightAttendants("Izzy Johnson", 27, 1014, "izzy.johnson@airline.com", "565656565", "Flight Attendant", 58000);
        FlightAttendants attendant4 = new FlightAttendants("Claire Redfield", 33, 1015, "claire.redfield@airline.com", "676767676", "Flight Attendant", 65000);
        FlightAttendants attendant5 = new FlightAttendants("Ava Wong", 30, 1016, "ava.wong@airline.com", "787878787", "Flight Attendant", 61000);
        CockpitCrew cockpitCrew1 = new CockpitCrew("Leon Kennedy", 45, 1008, "leon.kennedy@airline.com", "777777777", "Cockpit Crew", 90000);
        CockpitCrew cockpitCrew2 = new CockpitCrew("Klark Kent", 40, 1009, "klark.kent@airline.com", "888888888", "Cockpit Crew", 85000);
        CockpitCrew cockpitCrew3 = new CockpitCrew("James Wilson", 38, 1010, "james.wilson@airline.com", "141414141", "Cockpit Crew", 88000);
        CockpitCrew cockpitCrew4 = new CockpitCrew("James Bond", 42, 1011, "james.bond@airline.com", "252525252", "Cockpit Crew", 92000);
        Staff staff1 = new Staff("Emily Davis", 30, 1003, "emily.davis@airline.com", "555555555", "General Staff", 50000);
        Staff staff2 = new Staff("Michael Wilson", 35, 1099, "michael.wilson@airline.com", "666666666", "General Staff", 55000);
        Staff staff3 = new Staff("London Smith", 28, 1006, "london.smith@airline.com", "999999999", "General Staff", 52000);
        Staff staff4 = new Staff("Sarai Smith", 32, 1007, "sarah.smith@airline.com", "000000000", "General Staff", 58000);

        // Add staff to user log
        userLog.addStaff(staff1);
        userLog.addStaff(staff2);
        userLog.addStaff(staff3);
        userLog.addStaff(staff4);
        userLog.addStaff(cockpitCrew1);
        userLog.addStaff(cockpitCrew2);
        userLog.addStaff(cockpitCrew3);
        userLog.addStaff(cockpitCrew4);
        userLog.addStaff(s1);
        userLog.addStaff(s2);
        userLog.addStaff(s3);
        userLog.addStaff(s4);
        userLog.addStaff(s5);
        userLog.addStaff(attendant1);
        userLog.addStaff(attendant2);
        userLog.addStaff(attendant3);
        userLog.addStaff(attendant4);
        userLog.addStaff(attendant5);

        // Assign staff to flights
        flightManager.addStaffToFlight(flight1, s1);
        flightManager.addStaffToFlight(flight2, s2);
        flightManager.addStaffToFlight(flight3, s3);
        flightManager.addStaffToFlight(flight4, s4);
        flightManager.addStaffToFlight(flight1, s5);
        flightManager.addStaffToFlight(flight2, attendant1);
        flightManager.addStaffToFlight(flight3, attendant2);
        flightManager.addStaffToFlight(flight4, attendant3);
        flightManager.addStaffToFlight(flight1, attendant4);
        flightManager.addStaffToFlight(flight2, attendant5);
        flightManager.addStaffToFlight(flight3, cockpitCrew1);
        flightManager.addStaffToFlight(flight4, cockpitCrew2);
        flightManager.addStaffToFlight(flight1, cockpitCrew3);
        flightManager.addStaffToFlight(flight2, cockpitCrew4);
        flightManager.addStaffToFlight(flight3, staff1);
        flightManager.addStaffToFlight(flight4, staff2);
        flightManager.addStaffToFlight(flight1, staff3);
        flightManager.addStaffToFlight(flight2, staff4);
    }

    public void createFlightSchedule() {
        schedule.showSchedule(flightManager);
    }

    public void createPayments() {
        Payment payment1 = new Payment("Jack Slade", 600.0);
        Payment payment2 = new Payment("Johnny Cage", 800.0);
        Payment payment3 = new Payment("Richie Rich", 1000.0);
        Payment payment4 = new Payment("Gojo Satoru", 1500.0);

        paymentProcessor.addPayment(payment1);
        paymentProcessor.addPayment(payment2);
        paymentProcessor.addPayment(payment3);
        paymentProcessor.addPayment(payment4);
    }

    public Airline getAirline() {
        return airline;
    }

    public HumanResources getHumanResources() {
        return humanResources;
    }

    public AircraftManager getAircraftManager() {
        return aircraftManager;
    }

    public FlightManager getFlightManager() {
        return flightManager;
    }

    public TicketManager getTicketManager() {
        return ticketManager;
    }

    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }

    public FlightAttendants getFlightAttendants() {
        return flightAttendants;
    }

    public CockpitCrew getCockpitCrew() {
        return cockpitCrew;
    }

    public TSA getTsa() {
        return tsa;
    }

    public UserLog getUserLog() {
        return userLog;
    }

    public printTicket getTicketPrinter() {
        return ticketPrinter;
    }

    public Payment getPayment() {
        return payment;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Flight getFlight() {
        return flight;
    }

    public void start() {
        addAircraftManagerToStaff();
        createAircrafts();
        addFlightManagerToStaff();
        addTicketManagerToStaff();
        addPaymentProcessorToStaff();
        createFlights();
        createPayments();
    }
}