import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public static void generateIllegalArgumentException(String text) {
        System.out.println(text.substring(5, 2));
    }

    public static void handleIllegalArgumentException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught : " + e.getMessage());
            System.out.println("Start index must not be greater than end index.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string (at least 6 characters): ");
        String text = scanner.next();

        System.out.println("\n--- Handling IllegalArgumentException ---");
        handleIllegalArgumentException(text);

        System.out.println("\n--- Generating IllegalArgumentException (no handling) ---");
        generateIllegalArgumentException(text);

        scanner.close();
    }
}
