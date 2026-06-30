public class VehicleFleetDemo {
    public static class Vehicle {
        public void fuelCost(double km) {
            System.out.println("Base vehicle cost for " + km + " km");
        }
    }

    public static class Car extends Vehicle {
        @Override
        public void fuelCost(double km) {
            double cost = km * 8.5;
            System.out.println("Car fuel cost for " + km + " km: " + cost + " units");
        }
    }

    public static class Bus extends Vehicle {
        @Override
        public void fuelCost(double km) {
            double cost = km * 12.0;
            System.out.println("Bus fuel cost for " + km + " km: " + cost + " units");
        }
    }

    public static class Bike extends Vehicle {
        @Override
        public void fuelCost(double km) {
            double cost = km * 3.5;
            System.out.println("Bike fuel cost for " + km + " km: " + cost + " units");
        }
    }

    public static class ElectricCar extends Car {
        @Override
        public void fuelCost(double km) {
            double cost = km * 2.0;
            System.out.println("ElectricCar fuel cost for " + km + " km: " + cost + " units");
        }
    }

    public static void processFleet(Vehicle[] fleet, double km) {
        for (Vehicle vehicle : fleet) {
            if (vehicle == null) {
                continue;
            }
            if (vehicle instanceof Car) {
                ((Car) vehicle).fuelCost(km);
            } else if (vehicle instanceof Bus) {
                ((Bus) vehicle).fuelCost(km);
            } else if (vehicle instanceof Bike) {
                ((Bike) vehicle).fuelCost(km);
            } else {
                vehicle.fuelCost(km);
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] fleet = {new Car(), new Bus(), new Bike(), new ElectricCar()};
        processFleet(fleet, 100);
    }
}
