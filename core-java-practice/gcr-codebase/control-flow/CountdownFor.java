import java.util.Scanner;

public class CountdownFor {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter countdown start: ");
            int counter = input.nextInt();

            for (int i = counter; i >= 1; i--) {
                System.out.println(i);
            }
        }
    }
}