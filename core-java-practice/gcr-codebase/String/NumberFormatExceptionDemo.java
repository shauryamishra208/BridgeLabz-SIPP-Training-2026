import java.util.Scanner;

public class NumberFormatExceptionDemo {

    public static void generateNumberFormatException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    public static void handleNumberFormatException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught : " + e.getMessage());
            System.out.println("\"" + text + "\" cannot be converted to an integer.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-numeric string (e.g. hello): ");
        String text = scanner.next();

        System.out.println("\n--- Handling NumberFormatException ---");
        handleNumberFormatException(text);

        System.out.println("\n--- Generating NumberFormatException (no handling) ---");
        generateNumberFormatException(text);

        scanner.close();
    }
}
