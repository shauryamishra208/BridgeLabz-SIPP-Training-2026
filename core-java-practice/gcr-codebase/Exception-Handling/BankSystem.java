class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000.0);

        try {
            account.withdraw(1000);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdraw(10000);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdraw(-500);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
