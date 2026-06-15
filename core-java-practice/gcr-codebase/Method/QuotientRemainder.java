import java.util.Scanner;

public class QuotientRemainder {

    public static int[] findRemainderAndQuotient(int number, int divisor) {

        return new int[] { number / divisor, number % divisor };
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter Number: ");
            int number = input.nextInt();

            System.out.print("Enter Divisor: ");
            int divisor = input.nextInt();

            int[] result = findRemainderAndQuotient(number, divisor);

            System.out.println("Quotient = " + result[0]);
            System.out.println("Remainder = " + result[1]);
        }
    }
}
