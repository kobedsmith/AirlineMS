//Kobe Smith on 3/31/2026

/**
 * The Aircraft class represents an individual aircraft in the fleet of an airline.
 * It contains information about the aircraft's ID, model, seating capacity, and the
 * number of staff needed to operate it.
 */
public class Aircraft {
    private String ID;
    private String model;
    private int capacity;
    private int staffNeeded;

    /**
     * Constructor for the Aircraft class.
     * @param ID
     * @param model
     * @param capacity
     * @param staffNeeded
     */
    public Aircraft(String ID, String model, int capacity, int staffNeeded) {
        this.ID = ID;
        this.model = model;
        this.capacity = capacity;
        this.staffNeeded = staffNeeded;
    }

    public String getInfo() {
        return "Aircraft ID: " + this.ID + " - Model: " + this.model + " - Capacity: " + this.capacity;
    }

    /**
     * Gets the ID of the aircraft.
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the model of the aircraft.
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the seating capacity of the aircraft.
     * @return capcity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the number of staff needed to operate the aircraft.
     * @return staffNeeded
     */
    public int getStaffNeeded() {
        return staffNeeded;
    }
}