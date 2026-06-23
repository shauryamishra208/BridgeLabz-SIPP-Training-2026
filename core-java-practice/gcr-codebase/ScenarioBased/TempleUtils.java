public class TempleUtils {
    static int moveCount = 0;

    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 0) return;
        hanoi(n - 1, from, aux, to);
        moveCount++;
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        hanoi(n - 1, aux, to, from);
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] > target) return binarySearch(arr, low, mid - 1, target);
        return binarySearch(arr, mid + 1, high, target);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigits(n / 10);
    }

    public static String reverseString(String s) {
        if (s.isEmpty()) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static boolean isBalanced(String s, int index, int count) {
        if (count < 0) return false;
        if (index == s.length()) return count == 0;
        char c = s.charAt(index);
        if (c == '(') return isBalanced(s, index + 1, count + 1);
        if (c == ')') return isBalanced(s, index + 1, count - 1);
        return isBalanced(s, index + 1, count);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n, 'A', 'C', 'B');
        System.out.println("Total moves: " + moveCount);

        int[] prices = {10, 20, 30, 40, 50, 60, 70};
        System.out.println("Index of 50: " + binarySearch(prices, 0, prices.length - 1, 50));

        System.out.println("Sum of digits of 12345: " + sumOfDigits(12345));

        System.out.println("Reverse of 'hello': " + reverseString("hello"));

        System.out.println("Balanced '(()())': " + isBalanced("(()())", 0, 0));
        System.out.println("Balanced '(()': " + isBalanced("(()", 0, 0));
    }
}
