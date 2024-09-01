public class Payment {
    private double amount;
    private String paymentMethod; // e.g., Credit Card, Debit Card, Cash

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public boolean processPayment() {
        // Mock payment processing
        System.out.println("Processing payment of " + amount + " using " + paymentMethod);
        return true; // Assume payment is always successful
    }
}
