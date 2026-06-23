public class MobilePhone {
    private String brand;
    private String model;
    private double price;

    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public void displayDetails() {
        System.out.println("===== Mobile Phone Details =====");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.printf("Price : ₹%.2f%n", price);
    }

    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S24", 79999.00);
        MobilePhone phone2 = new MobilePhone("OnePlus", "12R", 42999.00);

        phone1.displayDetails();
        System.out.println();
        phone2.displayDetails();
    }
}
