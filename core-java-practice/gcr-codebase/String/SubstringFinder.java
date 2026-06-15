import java.util.Scanner;

class SubstringFinder {

    public static String createSubstringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
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

        System.out.print("Enter a string: ");
        String text = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String charAtSubstring  = createSubstringUsingCharAt(text, start, end);
        String builtInSubstring = text.substring(start, end);
        boolean areEqual        = compareUsingCharAt(charAtSubstring, builtInSubstring);

        System.out.println("\n--- Results ---");
        System.out.println("Substring using charAt()    : " + charAtSubstring);
        System.out.println("Substring using substring() : " + builtInSubstring);
        System.out.println("Both results are equal      : " + areEqual);

        scanner.close();
    }
}
