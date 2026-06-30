import java.util.ArrayList;
import java.util.List;

interface Trackable {
    void logActivity(String activity);

    default void resetData() {
        System.out.println("Activity data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private List<String> activities = new ArrayList<>();

    public void logActivity(String activity) {
        activities.add(activity);
        System.out.println("Logged activity: " + activity);
    }

    public void generateReport() {
        System.out.println("Fitness Report:");
        for (String a : activities) {
            System.out.println("- " + a);
        }
    }

    public void sendAlert(String message) {
        System.out.println("ALERT: " + message);
    }
}

public class FitnessTrackerDemo {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity("Running 5km");
        device.logActivity("Cycling 10km");
        device.generateReport();
        device.sendAlert("Heart rate too high!");
        device.resetData();

        Trackable t = new FitnessDevice();
        Reportable r = new FitnessDevice();
        Notifiable n = new FitnessDevice();
        System.out.println("FitnessDevice implements Trackable: " + (t instanceof Trackable));
        System.out.println("FitnessDevice implements Reportable: " + (r instanceof Reportable));
        System.out.println("FitnessDevice implements Notifiable: " + (n instanceof Notifiable));
    }
}
