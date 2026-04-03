//Kobe Smith on 3/31/2026

/**
 * The Passenger class represents a passenger traveling on an airline flight. It contains information
 * about the passenger's name, pnr, and email address. The class also provides methods for purchasing
 * tickets, requesting refunds, viewing their ticket information, getting their name and pnr.
 */
public class Passenger {
    private String name;
    private String pnr;
    private String email;

    /**
     * Constructor for the Passenger class.
     * @param name
     * @param email
     * @param pnr
     */
    public Passenger(String name, String email, String pnr) {
        this.name = name;
        this.email = email;
        this.pnr = pnr;
    }

    /**
     * Gets the name of the passenger.
     * @param paymentProcessor
     */
    public void buyTicket(PaymentProcessor paymentProcessor, Payment payment, NumTickets numTickets) {
        System.out.println(name + " is purchasing " + numTickets.getQuantity() + " ticket(s)...");
        paymentProcessor.processPayment(payment, numTickets, this);
        System.out.println("An purchase confirmation has been sent to " + email);
    }

    /**
     * Gets the email address of the passenger.
     * @param paymentProcessor
     */
    public void requestRefund(PaymentProcessor paymentProcessor, Payment payment, NumTickets numTickets) {
        System.out.println(name + " is requesting a refund...");
        paymentProcessor.processRefund(payment, this, numTickets);
        System.out.println("A refund confirmation has been sent to " + email);
    }

    /**
     * Allows the passenger to view their ticket information.
     * @param ticket
     */
    public void viewTicketInfo(printTicket printTicket, Flight flight, Ticket ticket) {
        printTicket.showTicketInfo(this, flight, ticket);
    }

    /**
     * Gets the name of the passenger.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the pnr of the passenger.
     * @return
     */
    public String getPnr() {
        return pnr;
    }
}