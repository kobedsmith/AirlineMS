//Kobe Smith on 3/31/2026

/**
 * The Flight class represents an individual flight operated by an airline.
 * It contains information about the flight's ID, origin, destination, departure time,
 * arrival time, and the aircraft assigned to the flight. This class is used by the 
 * FlightManager to manage the flights of an airline and to retrieve flight information.
 */
public class Flight {
    private String flightID;
    private String origin;
    private String destination;
    private String departureTime;
    private String gate;
    private String arrivalTime;
    private Aircraft aircraft;

    /**
     * Constructor for the Flight class.
     * @param flightID
     * @param origin
     * @param destination
     * @param departureTime
     * @param gate
     * @param arrivalTime
     * @param aircraft
     */
    public Flight(String flightID, String origin, String destination, String departureTime, String gate, String arrivalTime, Aircraft aircraft) {
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        this.arrivalTime = arrivalTime;
        this.aircraft = aircraft;
    }

    /**
     * Gets the flight ID.
     * @return flightID
     */
    public String getFlightID() {
        return flightID;
    }

    /**
     * Gets the origin of the flight.
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Gets the destination of the flight.
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Gets the departure time of the flight.
     * @return departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Gets the gate of the flight.
     * @return gate
     */
    public String getGate() {
        return gate;
    }

    /**
     * Gets the arrival time of the flight.
     * @return arrivalTime
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Gets the aircraft assigned to the flight.
     * @return aircraft
     */
    public Aircraft getAircraft() {
        return aircraft;
    }
}