import java.io.*;

public class GroceryBillReader {
    public static void main(String[] args) {
        String fileName = "bill.txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Milk - 50\n");
            fw.write("Bread - 40\n");
            fw.write("Eggs - 80\n");
            fw.write("Butter - 120\n");
            fw.write("Sugar - 60\n");
        } catch (IOException e) {
            System.out.println("Error creating bill file.");
        }

        int lineCount = 0;
        try (
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr)
        ) {
            System.out.println("===== Grocery Bill =====");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
            System.out.println("========================");
            System.out.println("Total lines: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
