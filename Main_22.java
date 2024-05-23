import java.util.ArrayList;
import java.util.Scanner;

// Purchasable interface
interface Purchasable {
    void addItem(int quantity);
    void removeItem(int quantity);
    double calculateTotalPrice();
}

// Electronics class
class Electronics implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough items to remove.");
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

// Clothing class
class Clothing implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough items to remove.");
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

// Books class
class Books implements Purchasable {
    private String name;
    private double price;
    private int quantity;

    public Books(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public void addItem(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough items to remove.");
        }
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

// ShoppingCartManager class
class ShoppingCartManager {
    private ArrayList<Purchasable> cart;
    private Scanner scanner;

    public ShoppingCartManager() {
        this.cart = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("A. Add an item to the cart");
            System.out.println("B. Remove an item from the cart");
            System.out.println("C. Display the cart");
            System.out.println("D. Calculate total price");
            System.out.println("E. Purchase items");
            System.out.println("F. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    addItemToCart();
                    break;
                case "B":
                    removeItemFromCart();
                    break;
                case "C":
                    displayCart();
                    break;
                case "D":
                    calculateTotalPrice();
                    break;
                case "E":
                    purchaseItems();
                    break;
                case "F":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addItemToCart() {
        System.out.println("Choose item type:");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");
        System.out.print("Choose an option: ");
        int itemType = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Purchasable item = null;
        switch (itemType) {
            case 1:
                item = new Electronics(name, price);
                break;
            case 2:
                item = new Clothing(name, price);
                break;
            case 3:
                item = new Books(name, price);
                break;
            default:
                System.out.println("Invalid item type.");
                return;
        }

        item.addItem(quantity);
        cart.add(item);
        System.out.println("Item added to cart.");
    }

    private void removeItemFromCart() {
        System.out.print("Enter item name to remove: ");
        String name = scanner.nextLine();

        Purchasable toRemove = null;
        for (Purchasable item : cart) {
            if (item.toString().contains(name)) {
                toRemove = item;
                break;
            }
        }

        if (toRemove != null) {
            System.out.print("Enter quantity to remove: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            toRemove.removeItem(quantity);
            if (toRemove.calculateTotalPrice() == 0) {
                cart.remove(toRemove);
            }
            System.out.println("Item removed from cart.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    private void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Purchasable item : cart) {
                System.out.println(item);
            }
        }
    }

    private void calculateTotalPrice() {
        double total = 0;
        for (Purchasable item : cart) {
            total += item.calculateTotalPrice();
        }
        System.out.println("Total price: $" + total);
    }

    private void purchaseItems() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            calculateTotalPrice();
            cart.clear();
            System.out.println("Items purchased successfully.");
        }
    }
}

// Main class to run the program
public class Main_22 {
    public static void main(String[] args) {
        ShoppingCartManager manager = new ShoppingCartManager();
        manager.menu();
    }
}
