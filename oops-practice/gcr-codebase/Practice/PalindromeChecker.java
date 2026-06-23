public class PalindromeChecker {
    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public boolean isPalindrome() {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public void displayResult() {
        System.out.println("===== Palindrome Checker =====");
        System.out.println("Text    : \"" + text + "\"");
        if (isPalindrome()) {
            System.out.println("Result  : It IS a palindrome!");
        } else {
            System.out.println("Result  : It is NOT a palindrome.");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker pc1 = new PalindromeChecker("madam");
        PalindromeChecker pc2 = new PalindromeChecker("hello");
        PalindromeChecker pc3 = new PalindromeChecker("racecar");
        PalindromeChecker pc4 = new PalindromeChecker("Never odd or even");

        pc1.displayResult();
        System.out.println();
        pc2.displayResult();
        System.out.println();
        pc3.displayResult();
        System.out.println();
        pc4.displayResult();
    }
}
