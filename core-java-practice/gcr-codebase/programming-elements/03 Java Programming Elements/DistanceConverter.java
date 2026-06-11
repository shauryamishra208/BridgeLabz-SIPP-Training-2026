import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        double yards = distanceInFeet / 3.0;
        double miles = yards / 1760.0;

        System.out.printf("The distance in yards is %.2f while the distance in miles is %.4f%n", yards, miles);
    }
}