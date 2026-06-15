import java.util.Scanner;

public class MaximumHandshakes {

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter number of students: ");
            int students = input.nextInt();

            System.out.println("Maximum possible handshakes = "
                    + calculateHandshakes(students));
        }
    }
}
