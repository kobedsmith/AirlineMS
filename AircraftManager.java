//Kobe Smith on 3/31/2026
import java.util.ArrayList;

/**
 * The AircraftManager class represents the department responsible for managing the fleet of aircraft
 * for an airline. It stores a list of aircraft and provides methods to add, remove, or retrieve 
 * information about the aircraft in the fleet.
 */
public class AircraftManager extends Staff{
    private ArrayList<Aircraft> aircraftList;

    /**
     * Constructor for the AircraftManager class.
     * @param aircraftList
     */
    public AircraftManager(String name, int age, int staffID, String email, String workNumber, String department, ArrayList<Aircraft> aircraftList) {
        super(name, age, staffID, email, workNumber, department);
        this.aircraftList = aircraftList;
    }

    public String getInfo() {
        return "Aircraft Manager: " + this.getName() + " - Staff ID: " + this.getStaffID() + " - Email: " + this.getEmail() + " - Work Number: " + this.getWorkNumber();
    }

    /**
     * Adds an aircraft to the fleet.
     * @param aircraft
     */
    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    /**
     * Removes an aircraft from the fleet.
     * @param aircraft
     */
    public void removeAircraft(Aircraft aircraft) {
        aircraftList.remove(aircraft);
    }

    /**
     * Retrieves the list of aircraft in the fleet
     * and prints their information.
     */
    public void displayFleet() {
        System.out.println("Fleet of Aircraft:");
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.getInfo());
        }
    }
}