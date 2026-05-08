//Kobe Smith on 4/6/2026

public class Cash extends Payment {
    double amount;
    String name;

    public Cash(double amount, String name) {
        super(name, amount);
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void paymentDetails() {
        System.out.println("\nPayment Amount: $" + this.getAmount());
        System.out.println("Name: " + this.getName());
    }
}