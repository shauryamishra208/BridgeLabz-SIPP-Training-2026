import java.io.*;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "report_card.txt";

        try (FileWriter fw = new FileWriter(inputFile)) {
            fw.write("Alice 85 90 78\n");
            fw.write("Bob 70 65 80\n");
            fw.write("Charlie 95 88 92\n");
        } catch (IOException e) {
            System.out.println("Error creating input file: " + e.getMessage());
        }

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(outputFile, true);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;
            bw.write("===== Report Card =====");
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                String name = parts[0];
                int total = 0;
                int count = parts.length - 1;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i]);
                }

                double avg = (double) total / count;
                String result = avg >= 75 ? "PASS" : "FAIL";

                String report = String.format("Name: %-10s | Average: %.2f | Result: %s", name, avg, result);
                System.out.println(report);
                bw.write(report);
                bw.newLine();
            }

            bw.write("=======================");
            bw.newLine();
            System.out.println("Report written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
