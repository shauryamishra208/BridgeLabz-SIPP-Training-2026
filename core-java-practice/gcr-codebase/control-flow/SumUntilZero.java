import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {`r`n        double total = 0.0;
        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            double value = input.nextDouble();
            if (value == 0) {
                break;
            }
            total += value;
        }
        System.out.println("Total = " + total);
        }`r`n    }
}

