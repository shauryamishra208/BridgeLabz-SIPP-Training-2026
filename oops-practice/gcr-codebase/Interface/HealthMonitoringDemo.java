interface HeartRateMonitor {
    int getHeartRate(String patientId);

    default void displayHealthTips() {
        System.out.println("Heart Health Tip: Maintain a normal heart rate between 60-100 bpm.");
    }
}

interface TemperatureMonitor {
    double getTemperature(String patientId);

    default void displayHealthTips() {
        System.out.println("Temperature Tip: Normal body temperature is around 98.6°F.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("P[0-9]{4}");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    public int getHeartRate(String patientId) {
        return 60 + (Math.abs(patientId.hashCode()) % 50);
    }

    public double getTemperature(String patientId) {
        return 97.0 + (Math.abs(patientId.hashCode()) % 30) / 10.0;
    }

    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void generateReport(String[] names, String[] ids) {
        System.out.println("Final Health Report:");
        for (int i = 0; i < ids.length; i++) {
            if (!TemperatureMonitor.isPatientIdValid(ids[i])) {
                System.out.println(names[i] + " (" + ids[i] + ") -> Invalid Patient ID");
                continue;
            }
            int heartRate = getHeartRate(ids[i]);
            double temp = getTemperature(ids[i]);
            System.out.println(names[i] + " (" + ids[i] + ") -> Heart Rate: " + heartRate
                    + " bpm, Temperature: " + temp + "F");
        }
    }
}

public class HealthMonitoringDemo {
    public static void main(String[] args) {
        String[] names = {"John", "Mary", "Steve"};
        String[] ids = {"P1001", "P2", "P3003"};

        HealthMonitoringSystem system = new HealthMonitoringSystem();
        system.displayHealthTips();
        system.generateReport(names, ids);
    }
}
