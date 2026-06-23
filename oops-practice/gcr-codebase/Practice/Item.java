public class Item {
    private String itemCode;
    private String itemName;
    private double price;

    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public void displayDetails() {
        System.out.println("===== Item Details =====");
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.printf("Price     : ₹%.2f%n", price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Item item1 = new Item("ITM001", "Notebook", 45.00);
        Item item2 = new Item("ITM002", "Pen", 10.00);

        item1.displayDetails();
        System.out.printf("Total cost for 5 units: ₹%.2f%n%n", item1.calculateTotalCost(5));

        item2.displayDetails();
        System.out.printf("Total cost for 12 units: ₹%.2f%n", item2.calculateTotalCost(12));
    }
}
