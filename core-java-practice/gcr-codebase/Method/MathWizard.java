import java.util.Scanner;

public class MathWizard {

    int instanceVar = 100;

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static long factorial(int n) {
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static double factorial(double n) {
        double fact = 1;

        for (int i = 1; i <= (int) n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int lcm(int a, int b) {
    if (a == 0 || b == 0)
        return 0;

    return Math.abs(a * b) / gcd(a, b);
    }
    public static long power(int base, int exp) {
        long result = 1;

        for (int i = 1; i <= exp; i++) {
            result *= base;
        }

        return result;
    }

    public void showScope() {
        int localVar = 50;

        System.out.println("Local Variable = " + localVar);
        System.out.println("Instance Variable = " + instanceVar);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to check Prime: ");
        int primeNum = sc.nextInt();

        System.out.print("Enter an integer for Factorial: ");
        int factInt = sc.nextInt();

        System.out.print("Enter a double for Factorial: ");
        double factDouble = sc.nextDouble();

        System.out.print("Enter n for Fibonacci: ");
        int fibNum = sc.nextInt();

        System.out.print("Enter first number for GCD & LCM: ");
        int a = sc.nextInt();

        System.out.print("Enter second number for GCD & LCM: ");
        int b = sc.nextInt();

        System.out.print("Enter base: ");
        int base = sc.nextInt();

        System.out.print("Enter exponent: ");
        int exp = sc.nextInt();

        System.out.println("\n----- Results -----");
        System.out.println("Is Prime? " + isPrime(primeNum));
        System.out.println("Factorial(int) = " + factorial(factInt));
        System.out.println("Factorial(double) = " + factorial(factDouble));
        System.out.println("Fibonacci = " + fibonacci(fibNum));
        System.out.println("GCD = " + gcd(a, b));
        System.out.println("LCM = " + lcm(a, b));
        System.out.println("Power = " + power(base, exp));

        MathWizard wizard = new MathWizard();
        wizard.showScope();

        sc.close();
    }
}
