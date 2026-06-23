import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class EmailDomainCounter {
    public static void main(String[] args) {
        String fileName = "emails.txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("rahul@gmail.com\n");
            fw.write("ankit@yahoo.com\n");
            fw.write("priya@gmail.com\n");
            fw.write("sneha@outlook.com\n");
            fw.write("ravi@yahoo.com\n");
            fw.write("meera@gmail.com\n");
        } catch (IOException e) {
            System.out.println("Error creating file.");
        }

        Map<String, Integer> domainCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.contains("@")) {
                    String domain = line.substring(line.indexOf("@") + 1);
                    domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("===== Email Domain Count =====");
        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " user(s)");
        }
    }
}
