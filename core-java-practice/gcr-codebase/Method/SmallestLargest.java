import java.util.Scanner;

public class SmallestLargest {

    public static int[] findSmallestAndLargest(int n1, int n2, int n3) {

        int smallest = Math.min(n1, Math.min(n2, n3));
        int largest = Math.max(n1, Math.max(n2, n3));

        return new int[] { smallest, largest };
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter first number: ");
            int n1 = input.nextInt();

            System.out.print("Enter second number: ");
            int n2 = input.nextInt();

            System.out.print("Enter third number: ");
            int n3 = input.nextInt();

            int[] result = findSmallestAndLargest(n1, n2, n3);

            System.out.println("Smallest = " + result[0]);
            System.out.println("Largest = " + result[1]);
        }
    }
}
