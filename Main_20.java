import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// BankAccount Interface
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankAccount targetAccount, double amount);
    void addTransaction(String transaction);
    void viewTransactions();
    double getBalance();
    String getAccountNumber();
}

// Abstract Class for common properties
abstract class AbstractBankAccount implements BankAccount {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactions;

    public AbstractBankAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        addTransaction("Account created with initial deposit of " + initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount <= balance) {
            withdraw(amount);
            targetAccount.deposit(amount);
            addTransaction("Transferred: $" + amount + " to Account " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    @Override
    public void viewTransactions() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}

// SavingsAccount Class
class SavingsAccount extends AbstractBankAccount {
    public SavingsAccount(String accountNumber, double initialDeposit) {
        super(accountNumber, initialDeposit);
    }
}

// CheckingAccount Class
class CheckingAccount extends AbstractBankAccount {
    public CheckingAccount(String accountNumber, double initialDeposit) {
        super(accountNumber, initialDeposit);
    }
}

// BankManager Class to handle user interactions
class BankManager {
    private List<BankAccount> accounts;
    private Scanner scanner;

    public BankManager() {
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transferFunds();
                    break;
                case 5:
                    viewTransactions();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter Account type (savings/checking): ");
        String type = scanner.nextLine().toLowerCase();
        System.out.print("Enter Initial deposit amount: ");
        double initialDeposit = Double.parseDouble(scanner.nextLine());
        String accountNumber = generateAccountNumber();

        BankAccount account;
        if (type.equals("savings")) {
            account = new SavingsAccount(accountNumber, initialDeposit);
        } else if (type.equals("checking")) {
            account = new CheckingAccount(accountNumber, initialDeposit);
        } else {
            System.out.println("Invalid account type. Account creation failed.");
            return;
        }

        accounts.add(account);
        System.out.println("Account created successfully! Account Number: " + accountNumber);
    }

    private void deposit() {
        BankAccount account = findAccount();
        if (account == null) return;

        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: $" + account.getBalance());
    }

    private void withdraw() {
        BankAccount account = findAccount();
        if (account == null) return;

        System.out.print("Enter withdrawal amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        account.withdraw(amount);
        System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
    }

    private void transferFunds() {
        System.out.print("Enter your account number: ");
        String fromAccountNumber = scanner.nextLine();
        BankAccount fromAccount = findAccountByNumber(fromAccountNumber);
        if (fromAccount == null) {
            System.out.println("Invalid account number.");
            return;
        }

        System.out.print("Enter target account number: ");
        String toAccountNumber = scanner.nextLine();
        BankAccount toAccount = findAccountByNumber(toAccountNumber);
        if (toAccount == null) {
            System.out.println("Invalid target account number.");
            return;
        }

        System.out.print("Enter transfer amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        fromAccount.transfer(toAccount, amount);
        System.out.println("Transfer successful. New balance: $" + fromAccount.getBalance());
    }

    private void viewTransactions() {
        BankAccount account = findAccount();
        if (account == null) return;

        account.viewTransactions();
    }

    private BankAccount findAccount() {
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        return findAccountByNumber(accountNumber);
    }

    private BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    private String generateAccountNumber() {
        return "ACCT" + (accounts.size() + 1);
    }
}

// Main class to run the program
public class Main_20 {
    public static void main(String[] args) {
        BankManager manager = new BankManager();
        manager.menu();
    }
}
