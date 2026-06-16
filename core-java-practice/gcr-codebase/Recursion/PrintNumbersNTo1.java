public class PrintNumbersNTo1 {

    static void printNumbers(int n) {
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        printNumbers(n - 1);
    }

    public static void main(String[] args) {
        int N = 5;
        printNumbers(N);
        System.out.println();
    }
}
