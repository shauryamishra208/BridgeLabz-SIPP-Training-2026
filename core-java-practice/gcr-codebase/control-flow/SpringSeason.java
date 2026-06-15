import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter month (1-12): ");
            int month = input.nextInt();

            System.out.print("Enter day: ");
            int day = input.nextInt();

            boolean isSpring = false;

            switch (month) {
                case 3:
                    isSpring = day >= 20 && day <= 31;
                    break;

                case 4:
                case 5:
                    isSpring = day >= 1 && day <= 31;
                    break;

                case 6:
                    isSpring = day >= 1 && day <= 20;
                    break;

                default:
                    isSpring = false;
                    break;
            }

            if (isSpring) {
                System.out.println("Its a Spring Season");
            } else {
                System.out.println("Not a Spring Season");
            }
        }
    }
}