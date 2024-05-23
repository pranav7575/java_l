import java.util.Arrays;
import java.util.Scanner;

public class Main_8{

    // Method to initialize an array with given elements
    public static int[] initializeArray(int size, Scanner scanner) {
        int[] array = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Method to find the sum of all elements in the array
    public static int findSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    // Method to find the maximum element in the array
    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Method to find the minimum element in the array
    public static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Method to sort the elements of the array in ascending order
    public static void sortArray(int[] array) {
        Arrays.sort(array);
    }

    // Method to reverse the elements of the array
    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array
        int[] array = initializeArray(size, scanner);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Find the sum of all elements");
            System.out.println("2. Find the maximum element");
            System.out.println("3. Find the minimum element");
            System.out.println("4. Sort the elements in ascending order");
            System.out.println("5. Reverse the elements of the array");
            System.out.println("6. Display the array");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int sum = findSum(array);
                    System.out.println("Sum of all elements: " + sum);
                    break;
                case 2:
                    int max = findMax(array);
                    System.out.println("Maximum element: " + max);
                    break;
                case 3:
                    int min = findMin(array);
                    System.out.println("Minimum element: " + min);
                    break;
                case 4:
                    sortArray(array);
                    System.out.println("Array sorted in ascending order.");
                    break;
                case 5:
                    reverseArray(array);
                    System.out.println("Array reversed.");
                    break;
                case 6:
                    System.out.println("Array elements: " + Arrays.toString(array));
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
