abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails(int days) {
        System.out.println("----------------------------------");
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Rental Days    : " + days);
        System.out.println("Rental Cost    : ₹" + calculateRentalCost(days));
        System.out.println("----------------------------------");
    }
}

class Car extends Vehicle {
    private double dailyRate;

    public Car(String vehicleNumber, double dailyRate) {
        super(vehicleNumber, "Car");
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public Bike(String vehicleNumber, double dailyRate) {
        super(vehicleNumber, "Bike");
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public Truck(String vehicleNumber, double dailyRate, double loadingCharge) {
        super(vehicleNumber, "Truck");
        this.dailyRate = dailyRate;
        this.loadingCharge = loadingCharge;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
    public double getLoadingCharge() { return loadingCharge; }
    public void setLoadingCharge(double loadingCharge) { this.loadingCharge = loadingCharge; }

    @Override
    public double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        int rentalDays = 5;

        Car car = new Car("MH-12-AB-1234", 1500);
        Bike bike = new Bike("MH-12-CD-5678", 500);
        Truck truck = new Truck("MH-12-EF-9012", 3000, 2000);

        System.out.println("===== Vehicle Rental Details =====");
        car.displayVehicleDetails(rentalDays);
        bike.displayVehicleDetails(rentalDays);
        truck.displayVehicleDetails(rentalDays);
    }
}
