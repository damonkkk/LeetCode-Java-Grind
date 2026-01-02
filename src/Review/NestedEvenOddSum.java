package Review;

import java.util.*;

public class NestedEvenOddSum {
    /**
     * Requirement:
     * Given a List of Lists of Integers, calculate the sum of even numbers
     * and the sum of odd numbers for each inner list.
     *
     * Return a List<List<Integer>> where each inner list contains exactly two elements:
     * [evenSum, oddSum].
     *
     * Rules:
     * 1. If an inner list is empty, both sums are 0.
     * 2. Handle negative numbers correctly (e.g., -2 is even, -3 is odd).
     * 3. Zero (0) is considered an even number.
     */
    public List<List<Integer>> calculateSums(List<List<Integer>> input) {
        // TODO: Implement logic
        return null;
    }

    public static void main(String[] args) {
        NestedEvenOddSum sol = new NestedEvenOddSum();

        List<List<Integer>> test1 = Arrays.asList(
                Arrays.asList(1, 2, 7),
                Arrays.asList(5, 8, 6),
                Arrays.asList(-1, -4, 0),
                new ArrayList<>() // Empty list case
        );

        System.out.println("Test 1: " + sol.calculateSums(test1));
        // Expected: [[2, 8], [14, 5], [-4, -1], [0, 0]]
    }
}