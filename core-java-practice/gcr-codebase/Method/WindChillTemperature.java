import java.util.Scanner;

public class WindChillTemperature {

    public static double calculateWindChill(double temperature,
                                            double windSpeed) {

        return 35.74
                + 0.6215 * temperature
                - 35.75 * Math.pow(windSpeed, 0.16)
                + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter temperature: ");
            double temperature = input.nextDouble();

            System.out.print("Enter wind speed: ");
            double windSpeed = input.nextDouble();

            System.out.println("Wind Chill Temperature = "
                    + calculateWindChill(temperature, windSpeed));
        }
    }
}
