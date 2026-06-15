public class NullPointerExceptionDemo {

    public static void generateNullPointerException() {
        String text = null;
        System.out.println(text.length());
    }

    public static void handleNullPointerException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught : " + e.getMessage());
            System.out.println("Cannot call methods on a null reference.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Handling NullPointerException ---");
        handleNullPointerException();

        System.out.println("\n--- Generating NullPointerException (no handling) ---");
        generateNullPointerException();
    }
}
