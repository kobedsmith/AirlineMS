//Kobe Smith on 3/31/2026
import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * The NumTickets class represents the number of tickets purchased for a flight, along with
 * the price per ticket and the total cost. It provides methods to retrieve the quantity and
 * total cost of the ticket(s).
 */
public class NumTickets {
    private int quantity;
    private double total;

    /**
     * Constructor for the NumTickets class.
     * @param quantity
     * @param ticket
     * @param econTickets
     * @param premTickets
     * @param busTickets
     * @param firstTickets
     */
    public NumTickets(int quantity, int total, Ticket ticket) {
        this.quantity = quantity;
        this.total = total;
    }

    /**
     * Gets the total cost of the tickets.
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     * Gets the quantity of tickets purchased.
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the total price of an economy ticket.
     * @return
     */
    public double getEconPrice(Ticket ticket) {
        total = quantity * (ticket.getEconPrice());
        return total;
    }

    /**
     * Gets the total price of a premium ticket.
     * @return
     */
    public double getPremPrice(Ticket ticket) {
        total = quantity * (ticket.getPremPrice());
        return total;
    }

    /**
     * Gets the total price of a business-class ticket.
     * @return
     */
    public double getBusPrice(Ticket ticket) {
        total = quantity * (ticket.getBusPrice());
        return total;
    }

    /**
     * Gets the total price of a first-class ticket.
     * @return
     */
    public double getFirstPrice(Ticket ticket) {
        total = quantity * (ticket.getFirstPrice());
        return total;
    }
}