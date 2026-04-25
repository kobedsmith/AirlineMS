//Kobe Smith on 4/6/2026

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