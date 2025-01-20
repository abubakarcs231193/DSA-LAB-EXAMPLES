import java.util.*;

public class BacktrackingWithArray {

    public static void generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);

        // Print all subsets
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    // Backtracking function
    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Explore further subsets by including numbers after 'start'
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in the current subset
            current.add(nums[i]);

            // Recur to add further numbers to the current subset
            backtrack(nums, i + 1, current, result);

            // Backtrack: remove the last element
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        generateSubsets(nums);
    }
}