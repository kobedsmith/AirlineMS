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
    private ArrayList<Flight> flightList;
    private ArrayList<Passenger> passengerList;
    private ArrayList<Staff> staffOnBoard;
    private int seatsAvailable;

    /**
     * Constructor for the FlightManager class.
     * @param flightList
     * @param passengerList
     * @param staffList
     */
    public FlightManager(String name, int age, int staffID, String email, String workNumber, String department, ArrayList<Flight> flightList, 
        ArrayList<Passenger> passengerList, ArrayList<Staff> staffOnBoard) {
        super(name, age, staffID, email, workNumber, department);
        this.flightList = flightList;
        this.passengerList = passengerList;
        this.staffOnBoard = staffOnBoard;
    }

    public String getInfo() {
        return "Flight Manager: " + this.getName() + " - Staff ID: " + this.getStaffID() + " - Email: " + this.getEmail() + " - Work Number: " + this.getWorkNumber();
    }

    /**
     * Adds a flight to the list of flights.
     * @param flight
     */
    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    /**
     * Removes a flight from the list of flights.
     * @param flight
     */
    public void removeFlight(Flight flight) {
        flightList.remove(flight);
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    /**
     * Adds a passenger to the list of passengers on flight.
     * @param passenger
     */
    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    /**
     * Removes a passenger from the list of passengers on flight.
     * @param passenger
     */
    public void removePassenger(Passenger passenger) {
        passengerList.remove(passenger);
    }

    public void displayPassengers(Flight flight) {
        System.out.println("List of Passengers on Flight " + flight.getFlightID() + ":");
        for (Passenger passenger : passengerList) {
            System.out.println(passenger);
        }
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    /**
     * Adds a staff member to the list of staff on flight.
     * @param staff
     */
    public void addStaff(Staff staff) {
        staffOnBoard.add(staff);
    }

    /**
     * Removes a staff member from the list of staff on flight.
     * @param staff
     */
    public void removeStaff(Staff staff) {
        staffOnBoard.remove(staff);
    }

    public void displayStaff(Flight flight) {
        System.out.println("List of Staff on Flight " + flight.getFlightID() + ":");
        for (Staff staff : staffOnBoard) {
            System.out.println(staff);
        }
    }

    /**
     * Retrieves the flight schedule.
     * @param flight
     */
    public void getFlight(Schedule schedule) {
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
        seatsAvailable = capacity - this.getPassengerList().size();
        return seatsAvailable;
    }
}