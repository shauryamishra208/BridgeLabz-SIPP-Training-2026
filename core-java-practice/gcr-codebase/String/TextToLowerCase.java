import java.util.Scanner;

class TextToLowerCase {

    public static String convertToLowerCase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                result += (char) (c + 32);
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

        String userDefinedLower = convertToLowerCase(text);
        String builtInLower     = text.toLowerCase();
        boolean areEqual        = compareUsingCharAt(userDefinedLower, builtInLower);

        System.out.println("\n--- Results ---");
        System.out.println("Original text             : " + text);
        System.out.println("Lowercase (user-defined)  : " + userDefinedLower);
        System.out.println("Lowercase (toLowerCase()) : " + builtInLower);
        System.out.println("Both results are equal    : " + areEqual);

        scanner.close();
    }
}
