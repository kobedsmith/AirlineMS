//Bryndon Hinton on 3/31/2026
import java.util.ArrayList;

/**
 * The Ticket class represents a ticket for a passenger on a specific flight. It contains information
 * about the ticket's class and price.
 */
public class Ticket {
    private String passengerPnr;
    private String classType;
    private String ticketID;
    private double price;    

    /**
     * Constructor for the Ticket class.
     * @param classType
     * @param ticketID
     */
    public Ticket(String classType, String ticketID, String passengerPnr, double price) {
        this.classType = classType;
        this.ticketID = ticketID;
        this.passengerPnr = passengerPnr;
        this.price = price;
    }

    public Ticket() {
        this.classType = "N/A";
        this.ticketID = "N/A";
        this.passengerPnr = "N/A";
        this.price = 0.0;
    }

    /**
     * Gets the class type of the ticket.
     * @return
     */
    public String getClassType() {
        return classType;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getPassengerPnr() {
        return passengerPnr;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculates the price of a economy ticket.
     * @return
     */
    public double getEconPrice() {
        if (classType.equalsIgnoreCase("Economy")) {
            price = 600.0;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return price;
    }

    public String getEconTicketId() {
        if (classType.equalsIgnoreCase("Economy")) {
            ticketID = "ECO-" + passengerPnr;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return ticketID;
    }

    /**
     * Calculates the price of a premium ticket.
     * @return
     */
    public double getPremPrice() {
        if (classType.equalsIgnoreCase("Premium")) {
            price = 800.0;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return price * 1.2;
    }

    public String getPremTicketId() {
        if (classType.equalsIgnoreCase("Premium")) {
            ticketID = "PREM-" + passengerPnr;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return ticketID;
    }

    /**
     * Calculates the price of a business-class ticket.
     * @return
     */
    public double getBusPrice() {
        if (classType.equalsIgnoreCase("Business")) {
            price = 1000.0;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return price * 2.0;
    }

    public String getBusTicketId() {
        if (classType.equalsIgnoreCase("Business")) {
            ticketID = "BUS-" + passengerPnr;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return ticketID;
    }

    /**
     * Calculates the price of a first-class ticket.
     * @return
     */
    public double getFirstPrice() {
        if (classType.equalsIgnoreCase("First Class")) {
            price = 1500.0;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return price * 3.0;
    }

    public String getFirstTicketId() {
        if (classType.equalsIgnoreCase("First Class")) {
            ticketID = "FIRST-" + passengerPnr;
        } else {
            System.out.println("This ticket is not a ticket type! Please try again.");
        }
        return ticketID;
    }

    public void addTicket(Ticket ticket, ArrayList<Ticket> ticketList) {
        ticketList.add(ticket);
    }

    public String toString() {
        return "Ticket ID: " + ticketID + ", Class: " + classType + ", Price: $" + price;
    }
}
