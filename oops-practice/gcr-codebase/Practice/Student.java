public class Student {
    private String name;
    private int rollNumber;
    private double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F (Fail)";
    }

    public void displayReport() {
        System.out.println("===== Student Report =====");
        System.out.println("Name        : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Marks       : " + marks + " / 100");
        System.out.println("Grade       : " + calculateGrade());
    }

    public static void main(String[] args) {
        Student s1 = new Student("Aarav Gupta", 1, 92.5);
        Student s2 = new Student("Sneha Verma", 2, 73.0);
        Student s3 = new Student("Rohit Kumar", 3, 45.0);

        s1.displayReport();
        System.out.println();
        s2.displayReport();
        System.out.println();
        s3.displayReport();
    }
}
