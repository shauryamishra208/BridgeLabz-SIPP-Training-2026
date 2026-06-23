import java.util.ArrayList;

public class CartItem {
    private final String itemName;
    private final double price;
    private int quantity;

    private static final ArrayList<CartItem> cart = new ArrayList<>();

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void addToCart() {
        for (CartItem item : cart) {
            if (item.itemName.equalsIgnoreCase(this.itemName)) {
                item.quantity += this.quantity;
                System.out.println(" \"" + itemName + "\" quantity updated in cart.");
                return;
            }
        }
        cart.add(this);
        System.out.println("\"" + itemName + "\" added to cart.");
    }

    public static void removeFromCart(String itemName) {
        boolean removed = cart.removeIf(item -> item.itemName.equalsIgnoreCase(itemName));
        if (removed) {
            System.out.println("🗑️  \"" + itemName + "\" removed from cart.");
        } else {
            System.out.println("Item \"" + itemName + "\" not found in cart.");
        }
    }

    public static void displayTotalCost() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("===== Shopping Cart =====");
        double total = 0;
        for (CartItem item : cart) {
            double subtotal = item.price * item.quantity;
            System.out.printf("%-20s x%d  @ ₹%.2f  =  ₹%.2f%n",
                    item.itemName, item.quantity, item.price, subtotal);
            total += subtotal;
        }
        System.out.println("-------------------------");
        System.out.printf("Total Cost : ₹%.2f%n", total);
    }

    public static void main(String[] args) {
        CartItem item1 = new CartItem("Rice (1kg)", 60.00, 2);
        CartItem item2 = new CartItem("Dal (500g)", 45.00, 3);
        CartItem item3 = new CartItem("Cooking Oil (1L)", 135.00, 1);

        item1.addToCart();
        item2.addToCart();
        item3.addToCart();

        System.out.println();
        displayTotalCost();

        System.out.println();
        removeFromCart("Dal (500g)");

        System.out.println();
        displayTotalCost();
    }
}
