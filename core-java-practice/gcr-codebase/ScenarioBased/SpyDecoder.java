import java.util.*;

public class SpyDecoder {
    public static void main(String[] args) {
        String msg = "level";
        String reversed = new StringBuilder(msg).reverse().toString();
        boolean isPalindrome = msg.equals(reversed);

        int vowels = 0, consonants = 0;
        for (char c : msg.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) vowels++;
            else if (Character.isLetter(c)) consonants++;
        }

        String intercept1 = "listen";
        String intercept2 = "silent";
        char[] a1 = intercept1.toCharArray();
        char[] a2 = intercept2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        boolean isAnagram = Arrays.equals(a1, a2);

        System.out.println("Original: " + msg);
        System.out.println("Reversed: " + reversed);
        System.out.println("Palindrome: " + isPalindrome);
        System.out.println("Vowels: " + vowels + " Consonants: " + consonants);
        System.out.println("Anagram: " + isAnagram);

        String log = "swiss";
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : log.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        char firstNonRepeating = '\0';
        for (char c : log.toCharArray()) {
            if (freq.get(c) == 1) {
                firstNonRepeating = c;
                break;
            }
        }

        System.out.println("First non-repeating: " + firstNonRepeating);
    }
}
