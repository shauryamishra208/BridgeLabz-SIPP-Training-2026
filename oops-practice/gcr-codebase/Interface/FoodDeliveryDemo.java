interface FoodDelivery {
    void deliverFood(String customer);

    default void trackOrder() {
        System.out.println("Tracking food order...");
    }

    static String generateDeliveryCode() {
        return "DEL-" + (int) (Math.random() * 90000 + 10000);
    }
}

interface GroceryDelivery {
    void deliverGrocery(String customer);

    default void trackOrder() {
        System.out.println("Tracking grocery order...");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    public void deliverFood(String customer) {
        System.out.println("Delivering food to " + customer + " with code " + FoodDelivery.generateDeliveryCode());
    }

    public void deliverGrocery(String customer) {
        System.out.println("Delivering groceries to " + customer + " with code " + FoodDelivery.generateDeliveryCode());
    }

    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }

    public void processDeliveries(String[] customers) {
        for (int i = 0; i < customers.length; i++) {
            trackOrder();
            if (i % 2 == 0) {
                deliverFood(customers[i]);
            } else {
                deliverGrocery(customers[i]);
            }
        }
    }
}

public class FoodDeliveryDemo {
    public static void main(String[] args) {
        String[] customers = {"Alice", "Bob", "Charlie", "Diana"};
        DeliveryExecutive executive = new DeliveryExecutive();
        executive.processDeliveries(customers);
    }
}
