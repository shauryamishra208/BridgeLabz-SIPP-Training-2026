class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
public class HospitalBillingSystem {
    static void makePayment(double billAmount, double amountPaid)
            throws InsufficientFundsException {
        if (amountPaid < billAmount) {
            throw new InsufficientFundsException(
                "Payment failed: Insufficient funds. Need ₹" +
                (billAmount - amountPaid) + " more."
            );
        }
        System.out.println("Payment successful!");
    }
    public static void main(String[] args) {
        try {
            int totalBill = 5000;
            int items = 0;
            double averageCost = totalBill / items;
            System.out.println("Average Cost: " + averageCost);

        } catch (ArithmeticException e) {
            System.out.println("Error: Bill contains zero items. Cannot calculate average cost.");
        }
        try {
            String[] patients = {"John", "Mary", "David"};
            System.out.println(patients[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index selected.");
        }
        try {
            String billAmount = "ABC";
            int amount = Integer.parseInt(billAmount);
            System.out.println(amount);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numeric input entered.");
        }
        try {
            makePayment(5000, 3000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
