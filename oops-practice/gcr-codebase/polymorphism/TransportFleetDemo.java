abstract class Vehicle {
    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    abstract double fuelCost(double km);
}

class Car extends Vehicle {
    Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    double fuelCost(double km) {
        return km * 8;
    }
}

class Bus extends Vehicle {
    Bus(String vehicleNumber) {
        super(vehicleNumber);
    }

    double fuelCost(double km) {
        return km * 15;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    double fuelCost(double km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String vehicleNumber) {
        super(vehicleNumber);
    }

    double fuelCost(double km) {
        return km * 2;
    }
}

public class TransportFleetDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("CAR101"),
            new Bus("BUS202"),
            new Bike("BIKE303"),
            new ElectricCar("ECAR404")
        };

        double km = 100;
        for (Vehicle v : fleet) {
            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println(c.vehicleNumber + " (Car) Fuel Cost: " + c.fuelCost(km));
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println(b.vehicleNumber + " (Bus) Fuel Cost: " + b.fuelCost(km));
            } else if (v instanceof Bike) {
                Bike bk = (Bike) v;
                System.out.println(bk.vehicleNumber + " (Bike) Fuel Cost: " + bk.fuelCost(km));
            } else if (v instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) v;
                System.out.println(ec.vehicleNumber + " (ElectricCar) Fuel Cost: " + ec.fuelCost(km));
            }
        }
    }
}
