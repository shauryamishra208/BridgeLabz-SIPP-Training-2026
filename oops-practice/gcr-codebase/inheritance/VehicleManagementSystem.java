interface Refuelable {
    void refuel();
}

class Vehicle {
    private String model;
    private int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() { return model; }
    public int getMaxSpeed() { return maxSpeed; }

    public void displayInfo() {
        System.out.println("Model     : " + model);
        System.out.println("Max Speed : " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(getModel() + " is charging. Battery capacity: "
                           + batteryCapacity + " kWh");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery   : " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private double tankCapacity;

    public PetrolVehicle(String model, int maxSpeed, double tankCapacity) {
        super(model, maxSpeed);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is being refuelled. Tank capacity: "
                           + tankCapacity + " litres");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tank      : " + tankCapacity + " litres");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 82);
        PetrolVehicle pv = new PetrolVehicle("Toyota Camry", 200, 60.0);

        System.out.println("=== Electric Vehicle ===");
        ev.displayInfo();
        ev.charge();

        System.out.println("\n=== Petrol Vehicle ===");
        pv.displayInfo();
        pv.refuel();

        Refuelable r = pv;
        System.out.println("\nRefuelling via interface reference:");
        r.refuel();
    }
}
