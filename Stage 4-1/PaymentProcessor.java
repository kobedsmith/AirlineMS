//Kobe Smith on 3/31/2026
import java.util.ArrayList;

/**
 * The PaymentProcessor class represents the department responsible for handling payment transactions for an airline.
 * It provides methods to process payments and refunds for passengers.
 */
public class PaymentProcessor extends Staff{
    Booking booking = new Booking();
    private ArrayList<Payment> paymentList = new ArrayList<>();

    /**
     * Constructor for the PaymentProcessor class.
     * @param name
     * @param age
     * @param staffID
     * @param email
     * @param workNumber
     * @param department
     */
    public PaymentProcessor(String name, int age, int staffID, String email, String workNumber, String department, int salary) {
        super(name, age, staffID, email, workNumber, department = "Payment Processing", salary);
    }

    public PaymentProcessor() {
        super("Default Payment Processor", 0, 0, "", "", "Payment Processing", 0);
    }

    public String getInfo() {
        return "Payment Processor: " + this.getName() + " - Staff ID: " + this.getStaffID() + " - Email: " + this.getEmail() + 
        " - Work Number: " + this.getWorkNumber();
    }

    /**
     * Processes a payment for a passenger.
     * @param payment
     * @param passenger
     */
    public void processPayment(Payment payment, double amount, Passenger passenger, String status) {
        System.out.println("Processing payment of $" + payment.getAmount(amount) + " for " + passenger.getName() + "...");
        System.out.println("Payment processed successfully! Thank you for your purchase!");
        booking.updateBookingStatus(status);
        paymentList.add(payment);
    }

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public void removePayment(Payment payment) {
        paymentList.remove(payment);
    }

    public ArrayList<Payment> getPaymentList() {
        return paymentList;
    }

    /**
     * Processes a refund for a passenger.
     * @param payment
     * @param refund
     */
    public void processRefund(Payment payment, double amount, Passenger passenger, double refund, String status) {
        refund = payment.getAmount(amount);
        System.out.println("Processing refund of $" + refund + " for " + passenger.getName() + "...");
        System.out.println("Refund processed successfully.");
        booking.updateBookingStatus(status);
        paymentList.remove(payment);
    }
}