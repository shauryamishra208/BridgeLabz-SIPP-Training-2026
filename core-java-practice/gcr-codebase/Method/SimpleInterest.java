import java.util.Scanner;

public class SimpleInterest {

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter Principal: ");
            double principal = input.nextDouble();

            System.out.print("Enter Rate: ");
            double rate = input.nextDouble();

            System.out.print("Enter Time: ");
            double time = input.nextDouble();

            double interest = calculateSimpleInterest(principal, rate, time);

            System.out.println("The Simple Interest is " + interest +
                    " for Principal " + principal +
                    ", Rate of Interest " + rate +
                    " and Time " + time);
        }
    }
}
