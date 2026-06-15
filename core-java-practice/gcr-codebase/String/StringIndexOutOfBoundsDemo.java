import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught : " + e.getMessage());
            System.out.println("Valid index range is 0 to " + (text.length() - 1));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        System.out.println("\n--- Handling StringIndexOutOfBoundsException ---");
        handleStringIndexOutOfBoundsException(text);

        System.out.println("\n--- Generating StringIndexOutOfBoundsException (no handling) ---");
        generateStringIndexOutOfBoundsException(text);

        scanner.close();
    }
}
