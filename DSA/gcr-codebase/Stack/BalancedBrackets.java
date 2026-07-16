import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BalancedBrackets {

    static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchFor = Map.of(')', '(', ']', '[', '}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || stack.pop() != matchFor.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {
            "{[()()]}",
            "{[(])}",
            "{[}",
            "((()))",
            ")",
            "(",
            "",
            "{\"a\":[1,2,{\"b\":3}]}".replaceAll("[^\\[\\]{}()]", "")
        };

        for (String t : tests) {
            System.out.printf("isValidConfig(\"%s\") -> %b%n", t, isValidConfig(t));
        }
    }
}
