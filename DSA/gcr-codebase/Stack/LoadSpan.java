import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LoadSpan {

    static int[] loadSpan(int[] load) {
        int n = load.length;
        int[] span = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] load = {60, 65, 68, 55, 70, 70, 72};
        int[] result = loadSpan(load);

        System.out.println("load: " + Arrays.toString(load));
        System.out.println("loadSpan: " + Arrays.toString(result));
    }
}
