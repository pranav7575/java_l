import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        int length = longestSubstringWithoutRepeatingChars(input);
        System.out.println("Length of the longest substring without repeating characters: " + length);
        
        scanner.close();
    }
    
    public static int longestSubstringWithoutRepeatingChars(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0, left = 0, right = 0;
        
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }
}
