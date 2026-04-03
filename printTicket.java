//Kobe Smith on 3/31/2026

/**
 * The PrintTicket class is responsible for displaying the information of a ticket for a passenger.
 * It takes in a Passenger object, a Flight object, and a Ticket object, and prints out the relevant
 * information such as the passenger's name, PNR, gate, flight ID, class, departure time, and arrival time.
 */
public class printTicket {
    public void showTicketInfo(Passenger passenger, Flight flight, Ticket ticket) {
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("PNR: " + passenger.getPnr());
        System.out.println("Gate: " + flight.getGate());
        System.out.println("Flight ID: " + flight.getFlightID());
        System.out.println("Class: " + ticket.getClassType());
        System.out.println("Departure: " + flight.getDepartureTime());
        System.out.println("Arrival: " + flight.getArrivalTime());
    }
}