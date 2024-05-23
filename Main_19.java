import java.util.Scanner;

class InvalidEmailException extends Exception {
    InvalidEmailException(String message) {
        super(message);
    }
}

public class Main_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email address: ");
        String email = scanner.nextLine();

        try {
            validateEmail(email);
            System.out.println("Valid email address.");
        } catch (InvalidEmailException e) {
            System.out.println("Invalid email address: " + e.getMessage());
        }

        scanner.close();
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        if (email.contains("@") && email.contains(".")) {
            int atIndex = email.indexOf("@");
            int dotIndex = email.lastIndexOf(".");
            if (atIndex < dotIndex) {
                System.out.println("Email address contains '@' and '.' in correct order.");
            } else {
                throw new InvalidEmailException("Email address should contain '@' before '.'");
            }
        } else {
            throw new InvalidEmailException("Email address should contain '@' and '.'");
        }
    }
}
