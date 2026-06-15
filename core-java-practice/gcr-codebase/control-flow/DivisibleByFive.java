import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {`r`n        System.out.print("Enter number: ");
        int number = input.nextInt();
        boolean divisible = number % 5 == 0;
        System.out.println("Is the number " + number + " divisible by 5? " + divisible);
        }`r`n    }
}

