import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught : " + e.getMessage());
            System.out.println("Valid index range is 0 to " + (names.length - 1));
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many names do you want to enter? ");
        int size = scanner.nextInt();
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.next();
        }

        System.out.println("\n--- Handling ArrayIndexOutOfBoundsException ---");
        handleArrayIndexOutOfBoundsException(names);

        System.out.println("\n--- Generating ArrayIndexOutOfBoundsException (no handling) ---");
        generateArrayIndexOutOfBoundsException(names);

        scanner.close();
    }
}
