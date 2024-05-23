import java.util.Scanner;

public class Main_5 {

    // Method to calculate the area of a rectangle
    public double calculateArea(double length, double width) {
        return length * width;
    }

    // Method to calculate the area of a square
    public double calculateArea(double side) {
        return side * side;
    }

    // Method to calculate the area of a circle
    public double calculateArea(double radius, boolean isCircle) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Calculate area of Rectangle");
            System.out.println("2. Calculate area of Square");
            System.out.println("3. Calculate area of Circle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter length of the rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter width of the rectangle: ");
                    double width = scanner.nextDouble();
                    double rectangleArea = calculator.calculateArea(length, width);
                    System.out.println("Area of the rectangle: " + rectangleArea);
                    break;
                case 2:
                    System.out.print("Enter side of the square: ");
                    double side = scanner.nextDouble();
                    double squareArea = calculator.calculateArea(side);
                    System.out.println("Area of the square: " + squareArea);
                    break;
                case 3:
                    System.out.print("Enter radius of the circle: ");
                    double radius = scanner.nextDouble();
                    double circleArea = calculator.calculateArea(radius, true);
                    System.out.println("Area of the circle: " + circleArea);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
