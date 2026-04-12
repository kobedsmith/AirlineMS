//Kobe Smith on 3/31/2026
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The FlightManager class represents the department responsible for managing the flights of an airline.
 * It stores a list of flights, passengers on each flight, and staff on each flight, and provides methods to 
 * add, remove, or retrieve information about them. It also calculates the number of staff needed on a flight 
 * and the number of seats available based on the aircraft's capacity and the number of passengers booked on the flight.
 */
public class FlightManager extends Staff{
    private ArrayList<Flight> flightList = new ArrayList<>();
    private ArrayList<String> passengerList = new ArrayList<>();
    private ArrayList<String> staffList = new ArrayList<>();
    private int seatsAvailable;

    /**
     * Constructor for the FlightManager class.
     * @param flightList
     * @param passengerList
     * @param staffList
     */
    public FlightManager(String name, int age, int staffID, String email, String workNumber, String department, int salary) {
        super(name, age, staffID, email, workNumber, department = "Flight Management", salary);
    }

    public FlightManager() {
        super("Default Flight Manager", 0, 0, "", "", "Flight Management", 0);
    }

    public String getInfo() {
        return "Flight Manager: " + this.getName() + " - Staff ID: " + this.getStaffID() + " - Email: " + this.getEmail() + " - Work Number: " + this.getWorkNumber();
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public void removeFlight(Flight flight) {
        flightList.remove(flight);
    }

    public ArrayList<Flight> flightList() {
        return flightList;
    }

    /**
     * Adds a passenger to the list of passengers on flight.
     * @param passenger
     */
    public void addPassenger(Passenger passenger, Flight flight) {
        passengerList.add("- " + passenger.getName() + " - Flight: " + flight.getFlightID());
    }

    /**
     * Removes a passenger from the list of passengers on flight.
     * @param passenger
     */
    public void removePassenger(Passenger passenger, Flight flight) {
        passengerList.remove("- " + passenger.getName() + " - Flight: " + flight.getFlightID());
    }

    public ArrayList<String> getPassengerList() {
        return passengerList;
    }

    /**
     * Adds a staff member to the list of staff on flight.
     * @param staff
     */
    public void addStaffToFlight(Flight flight, Staff staff) {
        staffList.add("- " + staff.getName() + " - Department: " + staff.getDepartment() + " - Flight: " + flight.getFlightID());
    }

    public void removeStaffFromFlight(String flight) {
        staffList.remove(flight);
    }

    public ArrayList<String> getStaffList() {
        return staffList;
    }

    /**
     * Retrieves the flight schedule.
     * @param flight
     */
    public void getFlightSchedule(Schedule schedule) {
        System.out.println(schedule);
    }

    /**
     * Calculates the number of seats available on a flight based on the aircraft's
     * capacity and the number of passengers booked on the flight.
     * @param aircraft
     * @param flight
     * @param capacity
     * @return seats available on flight
     */
    public int getSeatsAvailable(Aircraft aircraft, Flight flight, int capacity) {
        capacity = aircraft.getCapacity();
        seatsAvailable = capacity - passengerList.size();
        return seatsAvailable;
    }
}