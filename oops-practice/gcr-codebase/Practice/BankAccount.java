public class BankAccount {
    private final String accountHolder;
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() { return accountHolder; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Must be greater than 0.");
            return;
        }
        balance += amount;
        System.out.printf("₹%.2f deposited successfully.%n", amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Available: ₹" + balance);
        } else {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        }
    }

    public void displayBalance() {
        System.out.println("===== Account Details =====");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Balance        : ₹%.2f%n", balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Meera Joshi", "SBI1234567", 10000.00);

        account.displayBalance();
        System.out.println();

        account.deposit(5000);
        account.displayBalance();
        System.out.println();

        account.withdraw(3000);
        account.displayBalance();
        System.out.println();

        account.withdraw(20000);
    }
}
