//Kobe Smith on 3/31/2026
import java.util.ArrayList;

/**
 * The NumTickets class represents the number of tickets purchased for a flight, along with
 * the price per ticket and the total cost. It provides methods to retrieve the quantity and
 * total cost of the ticket(s).
 */
public class NumTickets {
    private String ticketType;
    private int quantity;

    /**
     * Constructor for the NumTickets class.
     * @param quantity
     * @param ticket
     */
    public NumTickets(int quantity, String ticketType) {
        this.quantity = quantity;
        this.ticketType = ticketType;
    }

    /**
     * Gets the quantity of tickets purchased.
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    public String getTicketType() {
        return ticketType;
    }

    /**
     * Gets the total price of an economy ticket.
     * @return
     */
    public double getEconPrice(Ticket ticket) {
        return quantity * (ticket.getEconPrice());
    }

    /**
     * Gets the total price of a premium ticket.
     * @return
     */
    public double getPremPrice(Ticket ticket) {
        return quantity * (ticket.getPremPrice());
    }

    /**
     * Gets the total price of a business-class ticket.
     * @return
     */
    public double getBusPrice(Ticket ticket) {
        return quantity * (ticket.getBusPrice());
    }

    /**
     * Gets the total price of a first-class ticket.
     * @return
     */
    public double getFirstPrice(Ticket ticket) {
        return quantity * (ticket.getFirstPrice());
    }
}