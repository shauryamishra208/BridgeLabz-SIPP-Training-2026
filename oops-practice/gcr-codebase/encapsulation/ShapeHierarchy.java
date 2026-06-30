abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
    public abstract String getName();

    public void displayReport() {
        System.out.printf("%-12s | Area: %10.2f | Perimeter: %10.2f%n",
                getName(), area(), perimeter());
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}

class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() { return sideA; }
    public void setSideA(double sideA) { this.sideA = sideA; }
    public double getSideB() { return sideB; }
    public void setSideB(double sideB) { this.sideB = sideB; }
    public double getSideC() { return sideC; }
    public void setSideC(double sideC) { this.sideC = sideC; }

    @Override
    public double area() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(7),
            new Rectangle(10, 5),
            new Triangle(3, 4, 5)
        };

        System.out.println("========== Shape Area Report ==========");
        System.out.printf("%-12s | %-14s | %-14s%n", "Shape", "Area", "Perimeter");
        System.out.println("---------------------------------------");

        for (Shape shape : shapes) {
            shape.displayReport();
        }

        System.out.println("=======================================");
    }
}
