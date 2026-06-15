import java.util.Scanner;

public class CountdownWhile {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter countdown start: ");
            int counter = input.nextInt();

            while (counter >= 1) {
                System.out.println(counter);
                counter--;
            }
        }
    }
}