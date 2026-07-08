import java.util.ArrayList;
import java.util.List;

public class SmartWarehouseSystem {
    static abstract class WarehouseItem {
        private final String name;

        public WarehouseItem(String name) {
            this.name = name;
        }

        public String getName() { return name; }

        public abstract String getCategory();

        @Override
        public String toString() {
            return getCategory() + ": " + name;
        }
    }

    static class Electronics extends WarehouseItem {
        public Electronics(String name) { super(name); }
        @Override public String getCategory() { return "Electronics"; }
    }

    static class Groceries extends WarehouseItem {
        public Groceries(String name) { super(name); }
        @Override public String getCategory() { return "Groceries"; }
    }

    static class Furniture extends WarehouseItem {
        public Furniture(String name) { super(name); }
        @Override public String getCategory() { return "Furniture"; }
    }

    static class Storage<T extends WarehouseItem> {
        private final List<T> items = new ArrayList<>();

        public void addItem(T item) {
            items.add(item);
        }

        public T getItem(int index) {
            return items.get(index);
        }

        public List<T> getItems() {
            return items;
        }
    }

    static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(" - " + item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));

        System.out.println("Electronics in storage:");
        displayAllItems(electronicsStorage.getItems());

        System.out.println("Groceries in storage:");
        displayAllItems(groceriesStorage.getItems());

        System.out.println("Furniture in storage:");
        displayAllItems(furnitureStorage.getItems());
    }
}
