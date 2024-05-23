import java.util.Scanner;

public class Main_9 
{

    // Method to concatenate two strings
    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    // Method to find the length of a string
    public static int findStringLength(String str) {
        return str.length();
    }

    // Method to convert a string to uppercase
    public static String convertToUpperCase(String str) {
        return str.toUpperCase();
    }

    // Method to convert a string to lowercase
    public static String convertToLowerCase(String str) {
        return str.toLowerCase();
    }

    // Method to check if a string contains a specific substring
    public static boolean containsSubstring(String str, String substring) {
        return str.contains(substring);
    }

    // Method to replace a substring with another substring in a string
    public static String replaceSubstring(String str, String oldSubstring, String newSubstring) {
        return str.replace(oldSubstring, newSubstring);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Concatenate strings
        String concatenatedString = concatenateStrings(str1, str2);
        System.out.println("Concatenated string: " + concatenatedString);

        // Find length of a string
        int length = findStringLength(concatenatedString);
        System.out.println("Length of the concatenated string: " + length);

        // Convert to uppercase
        String upperCaseString = convertToUpperCase(concatenatedString);
        System.out.println("Uppercase string: " + upperCaseString);

        // Convert to lowercase
        String lowerCaseString = convertToLowerCase(concatenatedString);
        System.out.println("Lowercase string: " + lowerCaseString);

        System.out.print("Enter a substring to check: ");
        String substring = scanner.nextLine();

        // Check if string contains substring
        boolean contains = containsSubstring(concatenatedString, substring);
        System.out.println("Does the concatenated string contain the substring? " + contains);

        System.out.print("Enter the old substring to replace: ");
        String oldSubstring = scanner.nextLine();

        System.out.print("Enter the new substring: ");
        String newSubstring = scanner.nextLine();

        // Replace substring
        String replacedString = replaceSubstring(concatenatedString, oldSubstring, newSubstring);
        System.out.println("String after replacing substring: " + replacedString);

        scanner.close();
    }
}
