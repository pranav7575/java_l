import java.util.Scanner;

public class Main_6 {

    // Constant value for PI
    public static final double PI;

    // Static block to initialize PI and print welcome message
    static {
        PI = 3.14;
        System.out.println("Welcome to the Simple Calculator Program!");
    }

    // Instance block to print message when a new instance is created
    {
        System.out.println("New calculator instance");
    }

    // Constructor
    public Main_6() {
        // Constructor can be empty or used to initialize instance variables if needed
    }

    // Method for addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main_6 calculator = new Main_6();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add two numbers");
            System.out.println("2. Subtract two numbers");
            System.out.println("3. Multiply two numbers");
            System.out.println("4. Divide two numbers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    double sum = calculator.add(num1, num2);
                    System.out.println("Result: " + sum);
                    break;
                case 2:
                    double difference = calculator.subtract(num1, num2);
                    System.out.println("Result: " + difference);
                    break;
                case 3:
                    double product = calculator.multiply(num1, num2);
                    System.out.println("Result: " + product);
                    break;
                case 4:
                    double quotient = calculator.divide(num1, num2);
                    if (!Double.isNaN(quotient)) {
                        System.out.println("Result: " + quotient);
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
