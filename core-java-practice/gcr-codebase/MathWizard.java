public class MathWizard {

    private int callCount = 0;

    public boolean isPrime(int n) {
        callCount++;
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public long factorial(int n) {
        callCount++;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double factorial(double n) {
        callCount++;
        int intPart = (int) n;
        return factorial(intPart);
    }

    public long fibonacci(int n) {
        callCount++;
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public int gcd(int a, int b) {
        callCount++;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        callCount++;
        return (a * b) / gcd(a, b);
    }

    public double power(double base, int exp) {
        callCount++;
        double result = 1.0;
        for (int i = 0; i < Math.abs(exp); i++) {
            result *= base;
        }
        return exp < 0 ? 1 / result : result;
    }

    public int getCallCount() {
        return callCount;
    }

    public void scopeDemo() {
        int callCount = 999;
        System.out.println("Local callCount inside scopeDemo(): " + callCount);
        System.out.println("Instance callCount (this.callCount): " + this.callCount);
    }

    public static void main(String[] args) {
        MathWizard wizard = new MathWizard();

        System.out.println("isPrime(17): " + wizard.isPrime(17));
        System.out.println("factorial(5): " + wizard.factorial(5));
        System.out.println("factorial(5.7): " + wizard.factorial(5.7));
        System.out.println("fibonacci(10): " + wizard.fibonacci(10));
        System.out.println("gcd(48, 18): " + wizard.gcd(48, 18));
        System.out.println("lcm(4, 6): " + wizard.lcm(4, 6));
        System.out.println("power(2, 10): " + wizard.power(2, 10));

        System.out.println("\n--- Scope Demo ---");
        wizard.scopeDemo();

        System.out.println("\nTotal methods called so far: " + wizard.getCallCount());
    }
}
