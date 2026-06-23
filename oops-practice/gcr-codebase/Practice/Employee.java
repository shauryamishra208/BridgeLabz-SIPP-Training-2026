public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void displayDetails() {
        System.out.println("===== Employee Details =====");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : ₹" + salary);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Rahul Sharma", 101, 55000.00);
        Employee emp2 = new Employee("Priya Patel", 102, 62000.50);

        emp1.displayDetails();
        System.out.println();
        emp2.displayDetails();
    }
}
