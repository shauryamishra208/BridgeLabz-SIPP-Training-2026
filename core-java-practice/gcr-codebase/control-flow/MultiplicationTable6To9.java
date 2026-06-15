import java.util.Scanner;

public class MultiplicationTable6To9 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {`r`n        System.out.print("Enter number: ");
        int number = input.nextInt();

        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }

        }`r`n    }
}

