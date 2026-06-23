import java.io.*;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        String fileName = "inventory.txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Laptop-10\n");
            fw.write("Mouse-0\n");
            fw.write("Keyboard-5\n");
            fw.write("Monitor-0\n");
            fw.write("Headphones-3\n");
        } catch (IOException e) {
            System.out.println("Error creating inventory file.");
        }

        System.out.println("===== Inventory Status =====");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String product = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    if (quantity == 0) {
                        System.out.println(product + " is out of stock");
                    } else {
                        System.out.println(product + " - Available (" + quantity + ")");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
