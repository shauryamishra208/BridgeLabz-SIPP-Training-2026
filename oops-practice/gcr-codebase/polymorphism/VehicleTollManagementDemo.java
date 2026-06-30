abstract class Vehicle {
    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    abstract double calculateToll();
}

class Car extends Vehicle {
    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 50;
    }
}

class Bus extends Vehicle {
    Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 120;
    }
}

class Truck extends Vehicle {
    Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 200;
    }
}

public class VehicleTollManagementDemo {
    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateToll();
        }
        return total;
    }

    static Vehicle searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equals(vehicleNumber)) {
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR101", "Alice"),
            new Bus("BUS202", "Bob"),
            new Truck("TRK303", "Charlie"),
            new Car("CAR104", "Diana"),
            new Truck("TRK305", "Evan")
        };

        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleNumber + " (" + v.ownerName + ") Toll: " + v.calculateToll());
        }

        System.out.println("Total Revenue: " + calculateTotalRevenue(vehicles));

        Vehicle found = searchVehicle(vehicles, "BUS202");
        if (found != null) {
            System.out.println("Found Vehicle: " + found.vehicleNumber + " owned by " + found.ownerName);
        }

        Vehicle highest = vehicles[0];
        for (Vehicle v : vehicles) {
            if (v.calculateToll() > highest.calculateToll()) {
                highest = v;
            }
        }
        System.out.println("Highest Toll Paid By: " + highest.vehicleNumber + " - " + highest.calculateToll());

        int carCount = 0;
        int busCount = 0;
        int truckCount = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                carCount++;
            } else if (v instanceof Bus) {
                busCount++;
            } else if (v instanceof Truck) {
                truckCount++;
            }
        }
        System.out.println("Cars: " + carCount + ", Buses: " + busCount + ", Trucks: " + truckCount);
    }
}
