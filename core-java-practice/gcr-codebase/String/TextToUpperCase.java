import java.util.Scanner;

class TextToUpperCase {

    public static String convertToUpperCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result += (char) (c - 32);
            } else {
                result += c;
            }
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String userDefinedUpper = convertToUpperCase(text);
        String builtInUpper     = text.toUpperCase();
        boolean areEqual        = compareUsingCharAt(userDefinedUpper, builtInUpper);

        System.out.println("\n--- Results ---");
        System.out.println("Original text             : " + text);
        System.out.println("Uppercase (user-defined)  : " + userDefinedUpper);
        System.out.println("Uppercase (toUpperCase()) : " + builtInUpper);
        System.out.println("Both results are equal    : " + areEqual);

        scanner.close();
    }
}
