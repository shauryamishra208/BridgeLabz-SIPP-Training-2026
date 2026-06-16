public class ReverseString {

    static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println(reverse(input));
    }
}
