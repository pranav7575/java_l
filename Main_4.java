import java.util.Scanner;

// Custom exception class
class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}

// TemperatureConverter class
class TemperatureConverter {
    private static final double MIN_CELSIUS = -273.15;
    private static final double MAX_CELSIUS = 1000.0;

    public static double celsiusToFahrenheit(double celsius) throws InvalidTemperatureException {
        if (celsius < MIN_CELSIUS || celsius > MAX_CELSIUS) {
            throw new InvalidTemperatureException("Temperature must be between " + MIN_CELSIUS + "°C and " + MAX_CELSIUS + "°C.");
        }
        return celsius * 9 / 5 + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) throws InvalidTemperatureException {
        double celsius = (fahrenheit - 32) * 5 / 9;
        if (celsius < MIN_CELSIUS || celsius > MAX_CELSIUS) {
            throw new InvalidTemperatureException("Temperature must be between " + MIN_CELSIUS + "°C and " + MAX_CELSIUS + "°C.");
        }
        return celsius;
    }
}

// Main class
public class Main_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature in Celsius: ");
                    double celsius = scanner.nextDouble();
                    try {
                        double fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
                        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
                    } catch (InvalidTemperatureException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter temperature in Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    try {
                        double celsiusConverted = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
                        System.out.println("Temperature in Celsius: " + celsiusConverted);
                    } catch (InvalidTemperatureException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
