import java.util.Scanner;

public class TrigonometricFunctions {

    public static double[] calculateTrigonometricFunctions(double angle) {

        double radians = Math.toRadians(angle);

        return new double[] {
                Math.sin(radians),
                Math.cos(radians),
                Math.tan(radians)
        };
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter angle in degrees: ");
            double angle = input.nextDouble();

            double[] result =
                    calculateTrigonometricFunctions(angle);

            System.out.println("Sin = " + result[0]);
            System.out.println("Cos = " + result[1]);
            System.out.println("Tan = " + result[2]);
        }
    }
}
