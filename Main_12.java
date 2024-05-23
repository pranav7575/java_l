import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main_12 {

    // Method to remove duplicates from an ArrayList
    public static ArrayList<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    // Method to check if an element exists in the ArrayList
    public static boolean elementExists(ArrayList<Integer> list, int element) {
        return list.contains(element);
    }

    // Method to add an element at a particular index in the ArrayList
    public static void addElementAtIndex(ArrayList<Integer> list, int index, int element) {
        list.add(index, element);
    }

    // Method to remove an element at a particular index in the ArrayList
    public static void removeElementAtIndex(ArrayList<Integer> list, int index) {
        list.remove(index);
    }

    // Method to sort the ArrayList
    public static void sortArrayList(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    // Method to reverse the elements in the ArrayList
    public static void reverseArrayList(ArrayList<Integer> list) {
        Collections.reverse(list);
    }

    // Method to compare two ArrayLists
    public static boolean compareArrayLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        return list1.equals(list2);
    }

    // Method to find the first and last occurrence of repeated elements
    public static void findFirstAndLastOccurrence(ArrayList<Integer> list, int element) {
        int firstIndex = list.indexOf(element);
        int lastIndex = list.lastIndexOf(element);
        if (firstIndex != -1) {
            System.out.println("First occurrence of " + element + ": " + firstIndex);
            System.out.println("Last occurrence of " + element + ": " + lastIndex);
        } else {
            System.out.println(element + " is not present in the list.");
        }
    }

    public static void main(String[] args) {
        // Sample input for removing duplicates
        ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(10, 20, 10, 15, 40, 15, 40));
        ArrayList<Integer> uniqueList = removeDuplicates(listWithDuplicates);
        System.out.println("Unique list: " + uniqueList);

        // Create a new ArrayList and perform various operations
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        
        // Check if an element exists
        int elementToCheck = 20;
        System.out.println("Does " + elementToCheck + " exist in the list? " + elementExists(list, elementToCheck));

        // Add element at a particular index
        int indexToAdd = 2;
        int elementToAdd = 25;
        addElementAtIndex(list, indexToAdd, elementToAdd);
        System.out.println("List after adding " + elementToAdd + " at index " + indexToAdd + ": " + list);

        // Remove element at a particular index
        int indexToRemove = 3;
        removeElementAtIndex(list, indexToRemove);
        System.out.println("List after removing element at index " + indexToRemove + ": " + list);

        // Sort the ArrayList
        sortArrayList(list);
        System.out.println("Sorted list: " + list);

        // Reverse the ArrayList
        reverseArrayList(list);
        System.out.println("Reversed list: " + list);

        // Compare two ArrayLists
        ArrayList<Integer> anotherList = new ArrayList<>(Arrays.asList(50, 40, 30, 25, 10));
        System.out.println("Are the two lists equal? " + compareArrayLists(list, anotherList));

        // Find first and last occurrence of repeated elements
        list.add(25);
        findFirstAndLastOccurrence(list, 25);
    }
}
