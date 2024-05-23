import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected String employeeID;

    public Employee(String name, String employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public abstract double calculateSalary();
    public abstract String evaluatePerformance();
    public abstract void displayDetails();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;
    private double performanceBonus;

    public FullTimeEmployee(String name, String employeeID, double monthlySalary, double performanceBonus) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + performanceBonus;
    }

    @Override
    public String evaluatePerformance() {
        // Simulate performance evaluation
        return "Excellent";
    }

    @Override
    public void displayDetails() {
        System.out.println("Full-Time Employee:");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Performance Bonus: " + performanceBonus);
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println("Performance: " + evaluatePerformance());
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    private double overtimeRate;
    private int overtimeHours;

    public PartTimeEmployee(String name, String employeeID, double hourlyRate, int hoursWorked, double overtimeRate, int overtimeHours) {
        super(name, employeeID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return (hourlyRate * hoursWorked) + (overtimeRate * overtimeHours);
    }

    @Override
    public String evaluatePerformance() {
        return "Performance evaluation not applicable for part-time employees.";
    }

    @Override
    public void displayDetails() {
        System.out.println("Part-Time Employee:");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Overtime Rate: " + overtimeRate);
        System.out.println("Overtime Hours: " + overtimeHours);
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println(evaluatePerformance());
    }
}

public class Main_15 {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Register Employee");
            System.out.println("2. Calculate Salary");
            System.out.println("3. Evaluate Performance");
            System.out.println("4. Display Employee Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerEmployee();
                    break;
                case 2:
                    calculateEmployeeSalary();
                    break;
                case 3:
                    evaluateEmployeePerformance();
                    break;
                case 4:
                    displayEmployeeDetails();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerEmployee() {
        System.out.print("Enter employee type (FullTime/PartTime): ");
        String type = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        if (type.equalsIgnoreCase("FullTime")) {
            System.out.print("Enter monthly salary: ");
            double monthlySalary = scanner.nextDouble();
            System.out.print("Enter performance bonus: ");
            double performanceBonus = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            employees.add(new FullTimeEmployee(name, employeeID, monthlySalary, performanceBonus));
        } else if (type.equalsIgnoreCase("PartTime")) {
            System.out.print("Enter hourly rate: ");
            double hourlyRate = scanner.nextDouble();
            System.out.print("Enter hours worked: ");
            int hoursWorked = scanner.nextInt();
            System.out.print("Enter overtime rate: ");
            double overtimeRate = scanner.nextDouble();
            System.out.print("Enter overtime hours: ");
            int overtimeHours = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            employees.add(new PartTimeEmployee(name, employeeID, hourlyRate, hoursWorked, overtimeRate, overtimeHours));
        } else {
            System.out.println("Invalid employee type.");
        }

        System.out.println("Employee registered successfully.");
    }

    private static void calculateEmployeeSalary() {
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.employeeID.equals(employeeID)) {
                System.out.println("Salary: " + emp.calculateSalary());
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void evaluateEmployeePerformance() {
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.employeeID.equals(employeeID)) {
                System.out.println("Performance: " + emp.evaluatePerformance());
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private static void displayEmployeeDetails() {
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.employeeID.equals(employeeID)) {
                emp.displayDetails();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
