//Kobe Smith on 3/31/2026

/**
 * The PaymentProcessor class represents the department responsible for handling payment transactions for an airline.
 * It provides methods to process payments and refunds for passengers.
 */
public class PaymentProcessor extends Staff{

    /**
     * Constructor for the PaymentProcessor class.
     * @param name
     * @param age
     * @param staffID
     * @param email
     * @param workNumber
     * @param department
     */
    public PaymentProcessor(String name, int age, int staffID, String email, String workNumber, String department) {
        super(name, age, staffID, email, workNumber, department);
    }

    public String getInfo() {
        return "Payment Processor: " + this.getName() + " - Staff ID: " + this.getStaffID() + " - Email: " + this.getEmail() + " - Work Number: " + this.getWorkNumber();
    }

    /**
     * Processes a payment for a passenger.
     * @param payment
     * @param passenger
     */
    public void processPayment(Payment payment, NumTickets numTickets, Passenger passenger) {
        System.out.println("Processing payment of $" + payment.getAmount() + " for " + passenger.getName() + "...");
        System.out.println("Payment processed successfully.");
    }

    /**
     * Processes a refund for a passenger.
     * @param payment
     * @param refund
     */
    public void processRefund(Payment payment, Passenger passenger, double refund) {
        refund = payment.getAmount();
        System.out.println("Processing refund of $" + refund + " for " + passenger.getName() + "...");
        System.out.println("Refund processed successfully.");
    }
}