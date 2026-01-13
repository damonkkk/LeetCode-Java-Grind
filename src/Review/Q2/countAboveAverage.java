package Review.Q2;

import java.util.ArrayList;
import java.util.List;

public class countAboveAverage {

    /**
     * Requirement:
     * For each inner list:
     * 1. Calculate the average of all numbers in that list.
     * 2. Count how many numbers in that specific list are GREATER than the average.
     *
     * Return a List<Integer> containing these counts for each row.
     *
     * Complexity:
     * Handle the case where a list contains only one number or is empty (average is 0).
     */
    public List<Integer> countAboveAverage(List<List<Integer>> input) {
        // TODO: Implement logic
        ArrayList<Integer> result = new ArrayList<>();


        return null;
    }
// Test Case: {{10, 20, 30}, {5, 5, 5}, {1, 100}} -> Expected: {1, 0, 1}
// (Row 1 avg=20, only 30 > 20. Row 2 avg=5, none > 5. Row 3 avg=50.5, 100 > 50.5)
}
