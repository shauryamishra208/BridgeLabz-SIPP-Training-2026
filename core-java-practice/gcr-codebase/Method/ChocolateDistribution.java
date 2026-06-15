import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] findDistribution(int chocolates, int children) {

        return new int[] {
                chocolates / children,
                chocolates % children
        };
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter chocolates: ");
            int chocolates = input.nextInt();

            System.out.print("Enter children: ");
            int children = input.nextInt();

            int[] result = findDistribution(chocolates, children);

            System.out.println("Each child gets = " + result[0]);
            System.out.println("Remaining chocolates = " + result[1]);
        }
    }
}
