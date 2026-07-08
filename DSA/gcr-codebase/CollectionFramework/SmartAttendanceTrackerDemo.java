import java.util.ArrayList;
import java.util.HashMap;

class SmartAttendanceTracker {
    private HashMap<String, ArrayList<String>> attendance;

    SmartAttendanceTracker() {
        attendance = new HashMap<>();
    }

    void markAttendance(String subject, String student) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendance.get(subject);
        if (students.contains(student)) {
            System.out.println(student + " is already marked present for " + subject);
            return;
        }
        students.add(student);
        System.out.println("Marked " + student + " present for " + subject);
    }

    void displayAttendance() {
        for (String subject : attendance.keySet()) {
            ArrayList<String> students = attendance.get(subject);
            System.out.println("Subject: " + subject + " | Students Present: " + students.size());
            for (String s : students) {
                System.out.println("- " + s);
            }
        }
    }
}

public class SmartAttendanceTrackerDemo {
    public static void main(String[] args) {
        SmartAttendanceTracker tracker = new SmartAttendanceTracker();
        tracker.markAttendance("Maths", "Alice");
        tracker.markAttendance("Maths", "Bob");
        tracker.markAttendance("Maths", "Alice");
        tracker.markAttendance("Science", "Bob");
        tracker.markAttendance("Science", "Charlie");

        tracker.displayAttendance();
    }
}
