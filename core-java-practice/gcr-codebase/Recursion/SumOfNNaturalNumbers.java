public class SumOfNNaturalNumbers {

    static int sumOfN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfN(n - 1);
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(sumOfN(N));
    }
}
