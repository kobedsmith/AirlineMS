// Kobe Smith on 3/31/2026

/**
 * The Airline class represents an airline company storing its name and headquarters location.
 * It also provides the methods to retrieve information about its various departments such as
 * Flight Manager, Aircraft Manager, Human Resources, Payment Processor, and TSA.
 */
public class Airline {
    private String name;
    private String headquarters;

    /**
     * Constructor for the Airline class.
     * @param name
     * @param headquarters
     */
    public Airline(String name, String headquarters) {
        this.name = name;
        this.headquarters = headquarters;
    }

    public Airline() {
        this.name = "Default Airline";
        this.headquarters = "Default Headquarters";
    }

    /**
     * Gets the name of the airline.
     * @return name of the airline
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the headquarters location of the airline.
     * @return location of the airline's headquarters
     */
    public String getHeadquarters() {
        return headquarters;
    }

    public void displayInformation() {
        System.out.println("Airline Name: " + name);
        System.out.println("Headquarters: " + headquarters);
    }
}