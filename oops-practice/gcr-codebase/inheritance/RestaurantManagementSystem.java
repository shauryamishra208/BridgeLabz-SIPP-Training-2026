interface Worker {
    void performDuties();
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }

    public void displayInfo() {
        System.out.println("Name : " + name + " | ID : " + id);
    }
}

class Chef extends Person implements Worker {
    private String speciality;

    public Chef(String name, int id, String speciality) {
        super(name, id);
        this.speciality = speciality;
    }

    public String getSpeciality() { return speciality; }

    @Override
    public void performDuties() {
        System.out.println(getName() + " (Chef) is preparing dishes. Speciality: " + speciality);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role       : Chef | Speciality: " + speciality);
    }
}

class Waiter extends Person implements Worker {
    private int tableCount;

    public Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    public int getTableCount() { return tableCount; }

    @Override
    public void performDuties() {
        System.out.println(getName() + " (Waiter) is serving customers at "
                           + tableCount + " tables.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role       : Waiter | Tables: " + tableCount);
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Marco", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Sam", 202, 5);

        System.out.println("=== Staff Info ===");
        chef.displayInfo();
        System.out.println();
        waiter.displayInfo();

        System.out.println("\n=== Duties ===");
        Worker[] staff = { chef, waiter };
        for (Worker w : staff) {
            w.performDuties();
        }

        System.out.println("\nInheritance checks:");
        System.out.println("chef   instanceof Person : " + (chef instanceof Person));
        System.out.println("waiter instanceof Person : " + (waiter instanceof Person));
        System.out.println("chef   instanceof Worker : " + (chef instanceof Worker));
        System.out.println("waiter instanceof Worker : " + (waiter instanceof Worker));
    }
}
