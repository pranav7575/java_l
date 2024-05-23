import java.util.Scanner;

class AdditionThread extends Thread {
    private double num1, num2;

    public AdditionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        double result = num1 + num2;
        System.out.println("Addition Result: " + result);
    }
}

class SubtractionThread extends Thread {
    private double num1, num2;

    public SubtractionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        double result = num1 - num2;
        System.out.println("Subtraction Result: " + result);
    }
}

class MultiplicationThread extends Thread {
    private double num1, num2;

    public MultiplicationThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        double result = num1 * num2;
        System.out.println("Multiplication Result: " + result);
    }
}

class DivisionThread extends Thread {
    private double num1, num2;

    public DivisionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void run() {
        if (num2 != 0) {
            double result = num1 / num2;
            System.out.println("Division Result: " + result);
        } else {
            System.out.println("Error: Division by zero");
        }
    }
}

public class Main_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = 0;
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = 0;
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        num2 = scanner.nextDouble();

        System.out.println("Choose operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int operation = 0;
        while (operation < 1 || operation > 4) {
            System.out.print("Enter your choice (1-4): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid choice (1-4).");
                scanner.next();
            }
            operation = scanner.nextInt();
            if (operation < 1 || operation > 4) {
                System.out.println("Invalid choice. Please enter a valid operation.");
            }
        }

        switch (operation) {
            case 1:
                AdditionThread additionThread = new AdditionThread(num1, num2);
                additionThread.start();
                break;
            case 2:
                SubtractionThread subtractionThread = new SubtractionThread(num1, num2);
                subtractionThread.start();
                break;
            case 3:
                MultiplicationThread multiplicationThread = new MultiplicationThread(num1, num2);
                multiplicationThread.start();
                break;
            case 4:
                DivisionThread divisionThread = new DivisionThread(num1, num2);
                divisionThread.start();
                break;
        }

        scanner.close();
    }
}
