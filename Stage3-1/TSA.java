//Bryndon Hinton on 3/31/2026

/**
 * The TSA class represents the Transportation Security Administration, which is responsible for
 * screening passengers before they board their flights. It contains information about the location
 * of the TSA checkpoint and the number of officers working there. The class also provides a method
 * to screen passengers.
 */
public class TSA {
    private String location;
    private int officerCount;

    /**
     * Constructor for the TSA class.
     * @param location
     * @param officerCount
     */
    public TSA(String location, int officerCount) {
        this.location = location;
        this.officerCount = officerCount;
    }

    public TSA() {
        this.location = "Default Location";
        this.officerCount = 0;
    }

    public String toString() {
        return "TSA Checkpoint Location: " + this.getLocation() + " - Number of Officers: " + this.getOfficerCount();
    }

    /**
     * Screens a passenger before they board their flight.
     * @param passenger
     */
    public void screenPassenger(Passenger passenger) {
        System.out.println("Screening passenger: " + passenger.getName() + "...");
        System.out.println("Passenger screened successfully.");
    }

    /**
     * Gets the location of the TSA checkpoint.
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the number of officers working at the TSA checkpoint.
     * @return
     */
    public int getOfficerCount() {
        return officerCount;
    }
}
