class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

class Student extends Person {
    private final int studentId;
    private double gpa;

    public Student(String name, int age, int studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public int getStudentId() { return studentId; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return "Student [" + super.toString() + ", studentId=" + studentId + ", gpa=" + gpa + "]";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, int studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    public String getThesis() { return thesis; }

    @Override
    public String toString() {
        return "GradStudent [" + super.toString() + ", thesis=\"" + thesis + "\"]";
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        GradStudent gs = new GradStudent("Alice", 26, 1001, 3.9, "Deep Learning in NLP");

        System.out.println(gs instanceof GradStudent);
        System.out.println(gs instanceof Student);
        System.out.println(gs instanceof Person);

        Person p = new Person("Bob", 40);
        Student s = new Student("Carol", 20, 1002, 3.5);

        System.out.println(p);
        System.out.println(s);
        System.out.println(gs);
    }
}
