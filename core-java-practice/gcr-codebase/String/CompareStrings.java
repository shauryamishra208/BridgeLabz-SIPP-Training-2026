import java.util.Scanner;

class CompareStrings {

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

        System.out.print("Enter first string: ");
        String s1 = scanner.next();

        System.out.print("Enter second string: ");
        String s2 = scanner.next();

        boolean charAtResult = compareUsingCharAt(s1, s2);
        boolean equalsResult = s1.equals(s2);

        System.out.println("\n--- Results ---");
        System.out.println("Using charAt() method : " + charAtResult);
        System.out.println("Using equals() method : " + equalsResult);
        System.out.println("Both methods agree    : " + (charAtResult == equalsResult));

        scanner.close();
    }
}
