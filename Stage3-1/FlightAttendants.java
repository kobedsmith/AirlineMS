//Dominic Gutierrez on 4/1/2026
import java.util.ArrayList;

/**
 * The FlightAttendants class represents a flight attendant working for an airline.
 * It extends the Staff class and includes additional functionality specific to flight
 * attendants, such as performing safety demonstrations, assisting passengers, and
 * serving meals. The class also includes a method to retrieve the flight attendant's salary.
 */
public class FlightAttendants extends Staff {
    /**
     * Constructor for the FlightAttendants class.
     * @param name
     * @param age
     * @param staffID
     * @param email
     * @param workNumber
     * @param department
     * @param salary
     */
    public FlightAttendants(String name, int age, int staffID, String email, String workNumber, String department, int salary) {
        super(name, age, staffID, email, workNumber, department = "Flight Attendant", salary);
    }

    public FlightAttendants() {
        super("Default Flight Attendant", 0, 0, "", "", "Flight Attendant", 0);
    }

    public String getName() {
        return super.getName();
    }

    public int getFlightAttendantID() {
        return super.getStaffID();
    }

    public int getSalary() {
        return super.getSalary();
    }

    /**
     * Performs a safety demonstration for passengers on the flight.
     */
    public void performSafetyDemonstration() {
        System.out.println("Performing safety demonstration...");
    }

    /**
     * Assists passengers during the flight, including helping with seating, providing information,
     * and addressing any concerns or needs they may have.
     */
    public void assistPassengers() {
        System.out.println("Assisting passengers...");
    }
}
