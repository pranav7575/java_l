import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main_14 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        // Count the occurrences of each element in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the intersection with nums2
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resultList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert the resultList to an array
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 1};
        int[] nums2 = {3, 2};
        int[] intersection1 = intersection(nums1, nums2);
        System.out.print("Intersection of nums1 and nums2: ");
        for (int num : intersection1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] intersection2 = intersection(nums3, nums4);
        System.out.print("Intersection of nums3 and nums4: ");
        for (int num : intersection2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
