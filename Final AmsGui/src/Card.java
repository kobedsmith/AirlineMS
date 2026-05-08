//Kobe Smith on 4/6/2026

public class Card extends Payment {
    private String cardHolderName;
    private String cardNumber;
    private String expirationDate;
    private int cvv;

    public Card(double amount, String cardNumber, String cardHolderName, String expirationDate, int cvv) {
        super(cardHolderName, amount);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void paymentDetails() {
        System.out.println("\nPayment method successfully entered into system!");
        System.out.println("Card Holder Name: " + getCardHolderName());
        System.out.println("Card Number: " + getCardNumber());
        System.out.println("Expiration Date: " + getExpirationDate());
        System.out.println("CVV: " + getCvv());
    }
}