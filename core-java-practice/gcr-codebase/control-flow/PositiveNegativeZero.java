import java.util.Scanner;

public class PositiveNegativeZero {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter number: ");
            int number = input.nextInt();

            if (number > 0) {
                System.out.println("positive");
            } else if (number < 0) {
                System.out.println("negative");
            } else {
                System.out.println("zero");
            }
        }
    }
}