public class DynamicOnlineMarketplace {
    interface Category {
        String getCategoryName();
    }

    static class BookCategory implements Category {
        @Override public String getCategoryName() { return "Book"; }
    }

    static class ClothingCategory implements Category {
        @Override public String getCategoryName() { return "Clothing"; }
    }

    static class GadgetCategory implements Category {
        @Override public String getCategoryName() { return "Gadget"; }
    }

    static class Product<T extends Category> {
        private final String name;
        private double price;
        private final T category;

        public Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
        public T getCategory() { return category; }

        @Override
        public String toString() {
            return String.format("%s [%s] - $%.2f", name, category.getCategoryName(), price);
        }
    }

    static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100.0);
        product.setPrice(newPrice);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 20.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 500.0, new GadgetCategory());

        System.out.println("Before discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        applyDiscount(book, 10);
        applyDiscount(shirt, 25);
        applyDiscount(phone, 15);

        System.out.println("\nAfter discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
