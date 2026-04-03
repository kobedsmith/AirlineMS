//Kobe Smith on 4/1/2026
import java.util.ArrayList;

/**
 * The TicketManager class represents the department responsible for managing the tickets of an airline.
 * It stores a list of tickets and provides methods to add, remove, or retrieve information about the tickets.
 * It also provides a method to display the list of tickets and their information.
 */
public class TicketManager extends Staff{
    private ArrayList<Ticket> ticketList;

    /**
     * Constructor for the TicketManager class.
     * @param ticketList
     */
    public TicketManager(String name, int age, int staffID, String email, String workNumber, String department, ArrayList<Ticket> ticketList) {
        super(name, age, staffID, email, workNumber, department);
        this.ticketList = ticketList;
    }

    public String getInfo() {
        return "Ticket Manager: " + this.getName() + " - Staff ID: " + this.getStaffID() + " - Email: " + this.getEmail() + " - Work Number: " + this.getWorkNumber();
    }

    /**
     * Adds a ticket to the list of tickets.
     * @param ticket
     */
    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    /**
     * Removes a ticket from the list of tickets.
     * @param ticket
     */
    public void removeTicket(Ticket ticket) {
        ticketList.remove(ticket);
    }

    /**
     * Retrieves the list of tickets and prints their information.
     */
    public void displayTickets(Passenger passenger) {
        System.out.println("List of Tickets:");
        for (Ticket ticket : ticketList) {
            System.out.println("------------------------------");
            System.out.println(passenger.getName() + " - " + ticket.getClassType());
            System.out.println("------------------------------");
        }
    }
}