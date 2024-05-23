import java.util.HashSet;

public class Main_10 {

    // Method to count unique words in the text
    public int countUniqueWords(String text) {
        // Split the text into words using whitespace as delimiter
        String[] words = text.split("\\s+");
        
        // Create a HashSet to store unique words
        HashSet<String> uniqueWords = new HashSet<>();
        
        // Add words to the HashSet
        for (String word : words) {
            uniqueWords.add(word);
        }
        
        // Return the size of the HashSet, which represents the count of unique words
        return uniqueWords.size();
    }

    public static void main(String[] args) {
        Main_10 wordCounter = new Main_10();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Ask user to input a text string
        System.out.print("Enter a text string: ");
        String text = scanner.nextLine();

        // Count unique words using WordCounter class
        int uniqueWordCount = wordCounter.countUniqueWords(text);

        // Display the number of unique words
        System.out.println("Number of unique words: " + uniqueWordCount);

        scanner.close();
    }
}
