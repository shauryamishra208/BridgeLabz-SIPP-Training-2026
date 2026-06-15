import java.util.Scanner;

public class SumNaturalNumbersWhile {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter number: ");
            int number = input.nextInt();

            if (number > 0) {
                int formulaSum = number * (number + 1) / 2;

                int loopSum = 0;
                int i = 1;

                while (i <= number) {
                    loopSum += i;
                    i++;
                }

                System.out.println("Formula sum = " + formulaSum);
                System.out.println("While loop sum = " + loopSum);
                System.out.println("Both results are equal? " + (formulaSum == loopSum));
            } else {
                System.out.println("The number " + number + " is not a natural number");
            }
        }
    }
}