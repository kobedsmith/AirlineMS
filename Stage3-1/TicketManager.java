//Kobe Smith on 4/1/2026
import java.util.ArrayList;

/**
 * The TicketManager class represents the department responsible for managing the tickets of an airline.
 * It stores a list of tickets and provides methods to add, remove, or retrieve information about the tickets.
 * It also provides a method to display the list of tickets and their information.
 */
public class TicketManager extends Staff{
    private ArrayList<Ticket> ticketTypes = new ArrayList<>();
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private ArrayList<String> passengerTickets = new ArrayList<>();
    Ticket ticket = new Ticket();

    /**
     * Constructor for the TicketManager class.
     * @param ticketList
     * @param totalStaffList
     * @param managers
     */
    public TicketManager(String name, int age, int staffID, String email, String workNumber, String department, int salary) {
        super(name, age, staffID, email, workNumber, department = "Ticket Management", salary);
    }

    public TicketManager() {
        super("Default Ticket Manager", 0, 0, "", "", "Ticket Management", 0);
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

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void addTicketType(Ticket ticket) {
        ticketTypes.add(ticket);
    }

    public void removeTicketType(Ticket ticket) {
        ticketTypes.remove(ticket);
    }

    public ArrayList<Ticket> getTicketTypes() {
        return ticketTypes;
    }

    public void addPassengerTicket(Ticket ticket, Passenger passenger, String flightID) {
        passengerTickets.add("- " + ticket.toString() + " - PNR: " + passenger.getPnr() + " - Flight: " + flightID);
    }

    public void removePassengerTicket(String ticket) {
        passengerTickets.remove(ticket);
    }

    public ArrayList<String> getPassengerTickets() {
        return passengerTickets;
    }

    public Ticket getTicketByPnr(String pnr) {
        for (Ticket ticket : ticketList) {
            if (ticket.getPassengerPnr().equals(pnr)) {
                return ticket;
            }
        }
        return null;
    }
}