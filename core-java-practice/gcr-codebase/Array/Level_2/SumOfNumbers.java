import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter up to 10 numbers (enter 0 or a negative number to stop):");

        while (true) {
            System.out.print("Enter number: ");
            double input = scanner.nextDouble();

            if (input <= 0) {
                System.out.println("Zero or negative number entered. Stopping input.");
                break;
            }

            if (index == 10) {
                System.out.println("Maximum limit of 10 numbers reached. Stopping input.");
                break;
            }

            numbers[index] = input;
            index++;
        }

        System.out.println("\n--- Entered Numbers ---");
        for (int i = 0; i < index; i++) {
            total += numbers[i];
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
        }

        System.out.println("\nSum of all numbers: " + total);

        scanner.close();
    }
}
