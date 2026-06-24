class Device {
    private String deviceId;
    private String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public String getDeviceId() { return deviceId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void displayStatus() {
        System.out.println("Device ID : " + deviceId);
        System.out.println("Status    : " + status);
    }
}

class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    public double getTemperatureSetting() { return temperatureSetting; }
    public void setTemperatureSetting(double temp) { this.temperatureSetting = temp; }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temp Set  : " + temperatureSetting + " °C");
    }
}

public class SmartHomeDevices {
    public static void main(String[] args) {
        Device light = new Device("DEV-001", "ON");
        Thermostat therm = new Thermostat("DEV-002", "ON", 22.5);

        System.out.println("=== Generic Device ===");
        light.displayStatus();

        System.out.println("\n=== Thermostat ===");
        therm.displayStatus();

        therm.setTemperatureSetting(24.0);
        System.out.println("\nAfter temperature update:");
        therm.displayStatus();
    }
}
