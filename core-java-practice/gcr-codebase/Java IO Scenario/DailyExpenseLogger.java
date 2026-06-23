import java.io.*;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        String fileName = "expenses.txt";
        Scanner sc = new Scanner(System.in);

        System.out.print("How many expenses do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter category (e.g. Food): ");
                String category = sc.nextLine();
                System.out.print("Enter amount: ");
                int amount = sc.nextInt();
                sc.nextLine();

                String entry = category + " - " + amount;
                bw.write(entry);
                bw.newLine();
                System.out.println("Saved: " + entry);
            }
            System.out.println("All expenses appended to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        sc.close();
    }
}
