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

    /**
     * Gets the information of the Flight Manager.
     * @param flightManager
     * @return string representation of the Flight Manager
     */
    public void getFlightManager(Staff flightmanager) {
        System.out.println(flightmanager.getInfo());
    }

    /**
     * Gets the information of the Aircraft Manager.
     * @param aircraftManager
     * @return string representation of the Aircraft Manager
     */
    public void getAircraftManager(Staff aircraftmanager) {
        System.out.println(aircraftmanager.getInfo());
    }

    /**
     * Gets the information of the Human Resources department.
     * @param humanResources
     * @return string representation of the Human Resources department
     */
    public void getHumanResources(HumanResources humanResources) {
        System.out.println(humanResources.getInfo());
    }

    /**
     * Gets the information of the Payment Processor.
     * @param paymentProcessor
     * @return string representation of the Payment Processor
     */
    public void getPaymentProcessor(Staff paymentProcessor) {
        System.out.println(paymentProcessor.getInfo());
    }

    /**
     * Gets the information of the TSA.
     * @param tsa
     * @return string representation of the TSA
     */
    public void getTSA(TSA tsa) {
        System.out.println(tsa.getInfo());
    }

    public void displayInformation() {
        System.out.println("Airline Name: " + name);
        System.out.println("Headquarters: " + headquarters);
    }
}