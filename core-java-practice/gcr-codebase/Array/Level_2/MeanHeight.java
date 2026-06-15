import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights (in cm) of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        double mean = sum / 11;

        System.out.println("\n--- Result ---");
        System.out.println("Sum of all heights: " + sum + " cm");
        System.out.printf("Mean height of the football team: %.2f cm%n", mean);

        scanner.close();
    }
}
