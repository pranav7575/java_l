import java.util.Arrays;
import java.util.Scanner;

public class Main_11 {

    // Method to check if a number is an Armstrong number
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numDigits = String.valueOf(number).length();

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits);
            number /= 10;
        }
        
        return sum == originalNumber;
    }

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    // Method to compare two dates of birth and determine relative age
    public static String compareDOB(String dob1, String dob2) {
        String[] parts1 = dob1.split("-");
        String[] parts2 = dob2.split("-");
        
        // Convert the date parts to integers for comparison
        int year1 = Integer.parseInt(parts1[0]);
        int month1 = Integer.parseInt(parts1[1]);
        int day1 = Integer.parseInt(parts1[2]);
        
        int year2 = Integer.parseInt(parts2[0]);
        int month2 = Integer.parseInt(parts2[1]);
        int day2 = Integer.parseInt(parts2[2]);

        // Compare years
        if (year1 < year2) {
            return "Elder";
        } else if (year1 > year2) {
            return "Younger";
        } else {
            // Compare months if years are equal
            if (month1 < month2) {
                return "Elder";
            } else if (month1 > month2) {
                return "Younger";
            } else {
                // Compare days if months are equal
                if (day1 < day2) {
                    return "Elder";
                } else if (day1 > day2) {
                    return "Younger";
                } else {
                    return "Same age";
                }
            }
        }
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Check if a number is Armstrong
        System.out.print("Enter a number to check if it is an Armstrong number: ");
        int armstrongNumber = scanner.nextInt();
        System.out.println(armstrongNumber + " is an Armstrong number: " + isArmstrong(armstrongNumber));

        // Check if two strings are anagrams
        scanner.nextLine(); // Consume the newline character left over from nextInt()
        System.out.print("Enter the first string to check for anagrams: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string to check for anagrams: ");
        String str2 = scanner.nextLine();
        System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are anagrams: " + areAnagrams(str1, str2));

        // Compare two dates of birth
        System.out.print("Enter the first date of birth (YYYY-MM-DD): ");
        String dob1 = scanner.nextLine();
        System.out.print("Enter the second date of birth (YYYY-MM-DD): ");
        String dob2 = scanner.nextLine();
        System.out.println("Comparison result: " + compareDOB(dob1, dob2));

        // Check if a number is prime
        System.out.print("Enter a number to check if it is prime: ");
        int primeNumber = scanner.nextInt();
        System.out.println(primeNumber + " is a prime number: " + isPrime(primeNumber));

        scanner.close();
    }
}
