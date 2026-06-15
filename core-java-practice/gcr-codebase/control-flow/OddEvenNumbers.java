import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {`r`n        System.out.print("Enter number: ");
        int number = input.nextInt();

        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is even");
                } else {
                    System.out.println(i + " is odd");
                }
            }
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }

        }`r`n    }
}

