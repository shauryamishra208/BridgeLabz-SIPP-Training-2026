import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class SmartCityTrafficMonitor {
    private HashMap<String, Integer> roadTraffic;

    SmartCityTrafficMonitor() {
        roadTraffic = new HashMap<>();
    }

    void recordVehicle(String road, int count) {
        roadTraffic.put(road, roadTraffic.getOrDefault(road, 0) + count);
    }

    void displaySorted() {
        TreeMap<String, Integer> sorted = new TreeMap<>(roadTraffic);
        System.out.println("Roads in sorted order:");
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vehicles");
        }
    }

    void displayBusiestRoad() {
        String busiest = null;
        int max = -1;
        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                busiest = entry.getKey();
            }
        }
        System.out.println("Busiest Road: " + busiest + " with " + max + " vehicles");
    }

    void generateReport() {
        System.out.println("Traffic Analysis Report:");
        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            String status = entry.getValue() > 500 ? "Heavy Traffic" : entry.getValue() > 200 ? "Moderate Traffic" : "Light Traffic";
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vehicles - " + status);
        }
        System.out.println("Total roads monitored: " + roadTraffic.size());
    }
}

public class SmartCityTrafficMonitorDemo {
    public static void main(String[] args) {
        SmartCityTrafficMonitor monitor = new SmartCityTrafficMonitor();
        monitor.recordVehicle("MG Road", 450);
        monitor.recordVehicle("Ring Road", 620);
        monitor.recordVehicle("Park Street", 150);
        monitor.recordVehicle("MG Road", 100);

        monitor.displaySorted();
        monitor.displayBusiestRoad();
        monitor.generateReport();
    }
}
