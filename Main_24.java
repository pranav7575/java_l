import java.util.ArrayList;
import java.util.List;

// Rentable interface
interface Rentable {
    void rent();
    void returnVehicle();
    double calculateRentalCost(int days);
    boolean isRented();
}

// Car class implementing Rentable
class Car implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Car(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }
}

// Motorcycle class implementing Rentable
class Motorcycle implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Motorcycle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }
}

// Bicycle class implementing Rentable
class Bicycle implements Rentable {
    private String model;
    private double dailyRate;
    private boolean isRented;

    public Bicycle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " is not rented.");
        }
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }
}

// RentalManager class
class RentalManager {
    private List<Rentable> vehicles;

    public RentalManager() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Rentable vehicle) {
        vehicles.add(vehicle);
    }

    public void rentVehicle(Rentable vehicle) {
        vehicle.rent();
    }

    public void returnVehicle(Rentable vehicle) {
        vehicle.returnVehicle();
    }

    public double calculateRentalCost(Rentable vehicle, int days) {
        return vehicle.calculateRentalCost(days);
    }
    
    public void listAvailableVehicles() {
        for (Rentable vehicle : vehicles) {
            if (!vehicle.isRented()) {
                System.out.println("Available vehicle: " + vehicle.toString());
            }
        }
    }
}

// Main class
public class Main_24 {
    public static void main(String[] args) {
        // Create instances of vehicles
        Car car1 = new Car("Toyota Corolla", 50);
        Motorcycle motorcycle1 = new Motorcycle("Harley Davidson", 75);
        Bicycle bicycle1 = new Bicycle("Giant TCR", 15);

        // Create rental manager
        RentalManager rentalManager = new RentalManager();

        // Add vehicles to rental manager
        rentalManager.addVehicle(car1);
        rentalManager.addVehicle(motorcycle1);
        rentalManager.addVehicle(bicycle1);

        // Rent a vehicle
        rentalManager.rentVehicle(car1);

        // Calculate rental cost
        System.out.println("Rental cost for 3 days: $" + rentalManager.calculateRentalCost(car1, 3));

        // Return a vehicle
        rentalManager.returnVehicle(car1);

        // List available vehicles
        rentalManager.listAvailableVehicles();
    }
}
