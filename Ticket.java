//Kobe Smith on 3/31/2026

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The Ticket class represents a ticket for a passenger on a specific flight. It contains information
 * about the ticket's class and price.
 */
public class Ticket {
    private String classType;
    private double price;
    

    /**
     * Constructor for the Ticket class.
     * @param classType
     * @param price
     */
    public Ticket(String classType, double price) {
        this.classType = classType;
        this.price = 600.0; // Base price for a ticket, can be adjusted based on class type
    }

    /**
     * Gets the class type of the ticket.
     * @return
     */
    public String getClassType() {
        return classType;
    }

    /**
     * Calculates the price of a economy ticket.
     * @return
     */
    public double getEconPrice() {
        return price;
    }

    /**
     * Calculates the price of a premium ticket.
     * @return
     */
    public double getPremPrice() {
        return price * 1.2;
    }

    /**
     * Calculates the price of a business-class ticket.
     * @return
     */
    public double getBusPrice() {
        return price * 2.0;
    }

    /**
     * Calculates the price of a first-class ticket.
     * @return
     */
    public double getFirstPrice() {
        return price * 3.0;
    }
}