import java.util.Scanner;

public class TriangularParkRounds {

    public static double calculateRounds(double side1, double side2, double side3) {

        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter side 1: ");
            double side1 = input.nextDouble();

            System.out.print("Enter side 2: ");
            double side2 = input.nextDouble();

            System.out.print("Enter side 3: ");
            double side3 = input.nextDouble();

            System.out.println("Rounds needed = "
                    + calculateRounds(side1, side2, side3));
        }
    }
}
