import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("The book is currently unavailable.");
        }
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", Availability=" + (isAvailable ? "Available" : "Borrowed") +
                '}';
    }
}

// LibraryManager class
class LibraryManager {
    private List<Book> books;
    private Scanner scanner;

    public LibraryManager() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("A. Add a new book");
            System.out.println("B. Borrow a book");
            System.out.println("C. Return a book");
            System.out.println("D. Search for a book by title");
            System.out.println("E. Search for a book by author");
            System.out.println("F. Display all available books");
            System.out.println("G. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    addBook();
                    break;
                case "B":
                    borrowBook();
                    break;
                case "C":
                    returnBook();
                    break;
                case "D":
                    searchByTitle();
                    break;
                case "E":
                    searchByAuthor();
                    break;
                case "F":
                    displayAvailableBooks();
                    break;
                case "G":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully.");
    }

    private void borrowBook() {
        System.out.print("Enter book ISBN to borrow: ");
        String isbn = scanner.nextLine();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isAvailable()) {
                    book.borrowBook();
                    System.out.println("You have borrowed the book successfully.");
                } else {
                    System.out.println("The book is currently unavailable.");
                }
                return;
            }
        }
        System.out.println("Book with this ISBN not found.");
    }

    private void returnBook() {
        System.out.print("Enter book ISBN to return: ");
        String isbn = scanner.nextLine();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) {
                    book.returnBook();
                    System.out.println("You have returned the book successfully.");
                } else {
                    System.out.println("The book is already available.");
                }
                return;
            }
        }
        System.out.println("Book with this ISBN not found.");
    }

    private void searchByTitle() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with this title.");
        }
    }

    private void searchByAuthor() {
        System.out.print("Enter book author to search: ");
        String author = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with this author.");
        }
    }

    private void displayAvailableBooks() {
        boolean found = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books in the library.");
        }
    }
}

// Main class to run the program
public class Main_21 {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.menu();
    }
}
