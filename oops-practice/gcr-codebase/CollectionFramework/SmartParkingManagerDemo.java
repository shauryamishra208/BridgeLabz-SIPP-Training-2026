import java.util.ArrayList;

class SmartParkingManager {
    private ArrayList<String> parkedVehicles;

    SmartParkingManager() {
        parkedVehicles = new ArrayList<>();
    }

    void enter(String vehicleNumber) {
        parkedVehicles.add(vehicleNumber);
        System.out.println(vehicleNumber + " has entered the parking area.");
    }

    void exit(String vehicleNumber) {
        if (parkedVehicles.remove(vehicleNumber)) {
            System.out.println(vehicleNumber + " has exited the parking area.");
        } else {
            System.out.println(vehicleNumber + " not found in parking area.");
        }
    }

    boolean search(String vehicleNumber) {
        return parkedVehicles.contains(vehicleNumber);
    }

    void displayAll() {
        System.out.println("Vehicles currently parked:");
        for (String v : parkedVehicles) {
            System.out.println(v);
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size());
    }
}

public class SmartParkingManagerDemo {
    public static void main(String[] args) {
        SmartParkingManager manager = new SmartParkingManager();
        manager.enter("MH12AB1234");
        manager.enter("KA05CD5678");
        manager.enter("DL08EF9012");

        System.out.println("Is KA05CD5678 parked? " + manager.search("KA05CD5678"));

        manager.exit("MH12AB1234");

        manager.displayAll();
    }
}
