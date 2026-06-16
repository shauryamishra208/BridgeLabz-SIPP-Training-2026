public class PermutationsGenerator {

    static void permute(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char chosen = remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            permute(prefix + chosen, newRemaining);
        }
    }

    public static void main(String[] args) {
        String input = "ABC";
        permute("", input);
    }
}
