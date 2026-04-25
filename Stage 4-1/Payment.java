//Kobe Smith on 4/6/2026

public class Payment {
    String name;
    double amount;

    public Payment(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void paymentDetails(double amount) {
        System.out.println("Amount Due: $" + amount);
    }

    public double getAmount(double amount) {
        return amount;
    }

    public String toString(){
        return "Transaction{name='" + name + "', amount=" + amount + "}";
    }
}