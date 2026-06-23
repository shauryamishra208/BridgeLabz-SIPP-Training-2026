import java.util.Scanner;

public class TaxCalculator {

    public static String getBracket(double income) {
        if (income < 10000) {
            return "5% bracket (Income < 10K)";
        } else if (income <= 50000) {
            return "15% bracket (10K - 50K)";
        } else {
            return "30% bracket (Above 50K)";
        }
    }

    public static double calculateTax(double income) {
        if (income < 10000) {
            return income * 0.05;
        } else if (income <= 50000) {
            return income * 0.15;
        } else {
            return income * 0.30;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter citizen's income: ");
        double income = scanner.nextDouble();

        String bracket = getBracket(income);
        double tax = calculateTax(income);

        System.out.println("\n--- Tax Report ---");
        System.out.printf("Income  : $%.2f%n", income);
        System.out.printf("Bracket : %s%n", bracket);
        System.out.printf("Tax Owed: $%.2f%n", tax);

        double[] incomes = {
            8000, 15000, 52000, 9999, 50000,
            120000, 32000, 7500, 60000, 45000
        };

        double totalTaxCollected = 0;

        System.out.println("\n--- Kingdom Tax Ledger (10 Citizens) ---");
        for (int i = 0; i < incomes.length; i++) {
            double citizenTax = calculateTax(incomes[i]);
            totalTaxCollected += citizenTax;

            System.out.printf(
                "Citizen %2d | Income: $%9.2f | Bracket: %-25s | Tax: $%8.2f%n",
                i + 1, incomes[i], getBracket(incomes[i]), citizenTax
            );
        }

        System.out.printf("%nTotal Tax Collected from Kingdom: $%.2f%n", totalTaxCollected);

        scanner.close();
    }
}
