import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goodCount = 0;
        int totalMessages = 5;

        System.out.println("Enter 5 feedback messages:");

        try {
            for (int i = 1; i <= totalMessages; i++) {
                System.out.print("Feedback " + i + ": ");
                String message = br.readLine();
                if (message != null && message.toLowerCase().contains("good")) {
                    goodCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }

        System.out.println("Good Feedback Count = " + goodCount);
    }
}
