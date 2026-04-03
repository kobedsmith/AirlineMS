//Kobe Smith on 4/1/2026

/**
 * The CockpitCrew class represents a member of the cockpit crew, such as a pilot or co-pilot, working for an airline.
 * It extends the Staff class and includes additional functionality specific to cockpit crew members, such as flying and
 * landing the aircraft. The class also includes a method to retrieve the cockpit crew member's salary.
 */
public class CockpitCrew extends Staff {
    private int salary;

    /**
     * Constructor for the CockpitCrew class.
     * @param name
     * @param age
     * @param staffID
     * @param email
     * @param workNumber
     * @param department
     * @param salary
     */
    public CockpitCrew(String name, int age, int staffID, String email, String workNumber, String department, int salary) {
        super(name, age, staffID, email, workNumber, department);
        this.salary = salary;
    }

    /**
     * Flies the aircraft.
     */
    public void flyAircraft() {
        System.out.println("Preparing for takeoff...");
        System.out.println("Now flying...");
    }

    /**
     * Lands the aircraft safely at the destination airport.
     */
    public void landAircraft() {
        System.out.println("Preparing for landing...");
        System.out.println("We have now landed safely!");
    }

    /**
     * Gets the cockpit crew member's salary.
     * @return
     */
    public int getSalary() {
        return salary;
    }
}