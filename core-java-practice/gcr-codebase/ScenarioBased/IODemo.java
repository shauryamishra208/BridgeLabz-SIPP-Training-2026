import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class IODemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a number: ");
        int num = Integer.parseInt(consoleReader.readLine());
        System.out.println("You entered: " + num);

        try (FileWriter writer = new FileWriter("notes.txt")) {
            writer.write("Hello, this is a test file.\n");
            writer.write("Second line of text.");
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        }

        Student s1 = new Student(name, num);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(s1);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student s2 = (Student) in.readObject();
            System.out.println("Deserialized: " + s2.name + ", Marks: " + s2.marks);
        }

        scanner.close();
        consoleReader.close();
    }
}
