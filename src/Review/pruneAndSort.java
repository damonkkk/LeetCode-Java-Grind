package Review;

import java.util.List;

public class pruneAndSort {

    /**
     * Requirement:
     * Transform the input List<List<Integer>> by:
     * 1. Removing all negative numbers from every inner list.
     * 2. If an inner list becomes empty after removal, add a single '0' to it.
     * 3. Sorting each inner list in descending order.
     *
     * Return the transformed List<List<Integer>>.
     */
    public List<List<Integer>> pruneAndSort(List<List<Integer>> input) {
        // TODO: Implement logic
        return null;
    }
// Test Case: {{1, -5, 3}, {-1, -2}, {0, 8}}
// Step 1: {{1, 3}, {}, {0, 8}}
// Step 2: {{1, 3}, {0}, {0, 8}}
// Step 3: {{3, 1}, {0}, {8, 0}} -> Expected result
}
