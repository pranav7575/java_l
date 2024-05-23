import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Employee class representing a generic employee
abstract class Employee {
    private String name;
    private int employeeID;
    private double hourlyRate;

    public Employee(String name, int employeeID, double hourlyRate) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public abstract double calculateMonthlySalary();
}

// FullTimeEmployee class representing a full-time employee
class FullTimeEmployee extends Employee {
    private double salary;
    private String benefits;

    public FullTimeEmployee(String name, int employeeID, double hourlyRate, double salary, String benefits) {
        super(name, employeeID, hourlyRate);
        this.salary = salary;
        this.benefits = benefits;
    }

    public double getSalary() {
        return salary;
    }

    public String getBenefits() {
        return benefits;
    }

    @Override
    public double calculateMonthlySalary() {
        return getSalary();
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "name='" + getName() + '\'' +
                ", employeeID=" + getEmployeeID() +
                ", hourlyRate=" + getHourlyRate() +
                ", salary=" + salary +
                ", benefits='" + benefits + '\'' +
                '}';
    }
}

// PartTimeEmployee class representing a part-time employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double overtimeRate;

    public PartTimeEmployee(String name, int employeeID, double hourlyRate, int hoursWorked, double overtimeRate) {
        super(name, employeeID, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    @Override
    public double calculateMonthlySalary() {
        double regularHours = Math.min(hoursWorked, 160);
        double overtimeHours = Math.max(0, hoursWorked - 160);
        return (regularHours * getHourlyRate()) + (overtimeHours * getOvertimeRate());
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "name='" + getName() + '\'' +
                ", employeeID=" + getEmployeeID() +
                ", hourlyRate=" + getHourlyRate() +
                ", hoursWorked=" + hoursWorked +
                ", overtimeRate=" + overtimeRate +
                '}';
    }
}

// EmployeeManager class to manage the list of employees
class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void calculateSalaries() {
        for (Employee employee : employees) {
            System.out.println("Monthly Salary of " + employee.getName() + " (ID: " + employee.getEmployeeID() + "): " + employee.calculateMonthlySalary());
        }
    }
}

// Main class to interact with the user
public class Main_2 {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a full-time employee");
            System.out.println("2. Add a part-time employee");
            System.out.println("3. Display all employees");
            System.out.println("4. Calculate monthly salaries");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String fullName = scanner.next();
                    System.out.print("Enter employee ID: ");
                    int fullID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double fullHourlyRate = scanner.nextDouble();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter benefits: ");
                    String benefits = scanner.next();
                    manager.addEmployee(new FullTimeEmployee(fullName, fullID, fullHourlyRate, salary, benefits));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String partName = scanner.next();
                    System.out.print("Enter employee ID: ");
                    int partID = scanner.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double partHourlyRate = scanner.nextDouble();
                    System.out.print("Enter hours worked: ");
                    int hoursWorked = scanner.nextInt();
                    System.out.print("Enter overtime rate: ");
                    double overtimeRate = scanner.nextDouble();
                    manager.addEmployee(new PartTimeEmployee(partName, partID, partHourlyRate, hoursWorked, overtimeRate));
                    break;
                case 3:
                    manager.displayEmployees();
                    break;
                case 4:
                    manager.calculateSalaries();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
