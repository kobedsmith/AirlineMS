//Kobe Smith on 3/31/2026

/**
 * The Schedule class represents the schedule of flights for an airline. It provides a method to display
 * the schedule of flights, including the flight ID, origin, destination, and duration.
 */
public class Schedule {
    public void showSchedule(FlightManager flightManager) {
        for (Flight f : flightManager.flightList()) {
            System.out.println("Flight ID: " + f.getFlightID());
            System.out.println("Origin: " + f.getOrigin());
            System.out.println("Destination: " + f.getDestination());
            System.out.println("------------------------");
        }
    }
}