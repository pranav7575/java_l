import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class Main_13 
{

    // Method to generate   a random array of integers with a specified size
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101); // Generates numbers from 0 to 100
        }
        return array;
    }

    // Method to rotate the elements of the array to the right by a specified number of positions
 
public static void rotateArray(int[] array, int positions) {
        int length = array.length;
        positions = positions % length;
        if (positions < 0) {
            positions += length;
        }
        reverseArray(array, 0, length - 1);
        reverseArray(array, 0, positions - 1);
        reverseArray(array, positions, length - 1);
    }

    // Helper method to reverse a portion of the array
    private static void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Method to remove duplicate elements from the array while preserving the original order
    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : array) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    // Method to rearrange the elements of the array such that all even numbers appear before all odd numbers
    public static int[] rearrangeEvenOdd(int[] array) {
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }
        evenList.addAll(oddList);
        int[] result = new int[evenList.size()];
        for (int i = 0; i < evenList.size(); i++) {
            result[i] = evenList.get(i);
        }
        return result;
    }

    // Method to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate a random array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = generateRandomArray(size);

        System.out.println("Generated array: ");
        printArray(array);

        // Rotate the array
        System.out.print("Enter the number of positions to rotate: ");
        int positions = scanner.nextInt();
        rotateArray(array, positions);
        System.out.println("Array after rotation: ");
        printArray(array);

        // Remove duplicates
        int[] arrayWithoutDuplicates = removeDuplicates(array);
        System.out.println("Array after removing duplicates: ");
        printArray(arrayWithoutDuplicates);

        // Rearrange even and odd numbers
        int[] rearrangedArray = rearrangeEvenOdd(arrayWithoutDuplicates);
        System.out.println("Array after rearranging even and odd numbers: ");
        printArray(rearrangedArray);

        scanner.close();
    }
}
