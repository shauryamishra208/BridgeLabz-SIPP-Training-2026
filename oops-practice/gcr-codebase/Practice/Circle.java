public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void displayDetails() {
        System.out.println("===== Circle Details =====");
        System.out.println("Radius        : " + radius);
        System.out.printf("Area          : %.2f%n", calculateArea());
        System.out.printf("Circumference : %.2f%n", calculateCircumference());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(7.0);
        Circle c2 = new Circle(3.5);

        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
    }
}
