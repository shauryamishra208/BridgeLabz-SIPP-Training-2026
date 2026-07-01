package encapsulation;
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public abstract double calculateTotalPrice();

    public void displayItemDetails() {
        System.out.println("----------------------------------");
        System.out.println("Item Name   : " + itemName);
        System.out.println("Item Type   : " + getClass().getSimpleName());
        System.out.println("Price       : ₹" + price);
        System.out.println("Quantity    : " + quantity);
        System.out.println("Total Price : ₹" + calculateTotalPrice());
        System.out.println("----------------------------------");
    }
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem {
    private double serviceCharge;

    public NonVegItem(String itemName, double price, int quantity, double serviceCharge) {
        super(itemName, price, quantity);
        this.serviceCharge = serviceCharge;
    }

    public double getServiceCharge() { return serviceCharge; }
    public void setServiceCharge(double serviceCharge) { this.serviceCharge = serviceCharge; }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + serviceCharge) * getQuantity();
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        VegItem vegItem = new VegItem("Paneer Butter Masala", 280, 2);
        NonVegItem nonVegItem = new NonVegItem("Chicken Biryani", 350, 3, 30);

        System.out.println("===== Online Food Delivery System =====");
        vegItem.displayItemDetails();
        nonVegItem.displayItemDetails();
    }
}
