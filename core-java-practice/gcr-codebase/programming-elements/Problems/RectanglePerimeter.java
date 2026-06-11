import java.util.Scanner;

public class RectanglePerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rectangle length: ");
        double length = input.nextDouble();
        System.out.print("Enter rectangle width: ");
        double width = input.nextDouble();
        double perimeter = 2 * (length + width);
        System.out.println("Perimeter of the rectangle = " + perimeter);
    }
}
