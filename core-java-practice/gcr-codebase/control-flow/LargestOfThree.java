import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {`r`n        System.out.print("Enter first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter second number: ");
        int number2 = input.nextInt();
        System.out.print("Enter third number: ");
        int number3 = input.nextInt();
        boolean firstLargest = number1 >= number2 && number1 >= number3;
        boolean secondLargest = number2 >= number1 && number2 >= number3;
        boolean thirdLargest = number3 >= number1 && number3 >= number2;
        System.out.println("Is the first number the largest? " + firstLargest);
        System.out.println("Is the second number the largest? " + secondLargest);
        System.out.println("Is the third number the largest? " + thirdLargest);
        }`r`n    }
}

