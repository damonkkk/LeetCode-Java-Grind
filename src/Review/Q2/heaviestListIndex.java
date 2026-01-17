package Review.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class heaviestListIndex {

    /**
     * Requirement:
     * Identify which inner list has the highest "Weight".
     * "Weight" = (Sum of all elements) / (Number of elements).
     * Return the index of the "Heaviest" list.
     *
     * Complexity:
     * 1. Return -1 if the input is null or all lists are empty.
     * 2. Use 'double' for weight calculations to maintain precision.
     */
    public int heaviestListIndex(List<List<Integer>> input) {
        if(input == null || input.isEmpty()){
            return -1;
        }
        // pick the smallest possible value that Java supports
        double maxWeight =-Double.MAX_VALUE;
        // initialise the index to -1;
        int idx = -1;

        // for every list of the list of list
        for(int i=0; i<input.size();i++){
            // jump off the empty and null lists
            if(input.get(i) == null|| input.get(i).isEmpty()){
                continue;
            }
            // initialise the sum of each list
            double sum = 0;
            // calculate the sum
            for(int x : input.get(i)){
             sum +=x;
        }
            // calculate the weight, if anything relate to divide, must use double
            double weight = sum / input.get(i).size();
            // update the maximum weight
            // finally we will return the max weight 's list 's index
            if(weight>maxWeight){
                maxWeight = weight;
                idx = i;
            }

        }

        return idx;
    }
// Test Case: {{10, 10}, {100}, {50, 50, 50}} -> Expected: 1
// (Weights: row0=10.0, row1=100.0, row2=50.0)

    public static void main(String[] args) {
        heaviestListIndex solution = new heaviestListIndex();

        // Test Case 1: Standard Case
        // Row 0: {10, 10} -> Weight: 10.0
        // Row 1: {100}    -> Weight: 100.0 (Winner!)
        // Row 2: {50, 50, 50} -> Weight: 50.0
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(10, 10));
        test1.add(Arrays.asList(100));
        test1.add(Arrays.asList(50, 50, 50));
        System.out.println("Test 1 (Standard): " + solution.heaviestListIndex(test1));
        // Expected: 1

        // Test Case 2: Average vs. Total Sum
        // Row 0: {1, 1, 1, 1, 1, 1} -> Sum: 6, Weight: 1.0
        // Row 1: {5, 5}             -> Sum: 10, Weight: 5.0 (Winner!)
        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(Arrays.asList(1, 1, 1, 1, 1, 1));
        test2.add(Arrays.asList(5, 5));
        System.out.println("Test 2 (Avg vs Sum): " + solution.heaviestListIndex(test2));
        // Expected: 1

        // Test Case 3: Negative Numbers
        // Row 0: {-10, -20} -> Weight: -15.0
        // Row 1: {-5}       -> Weight: -5.0 (Winner! -5 is greater than -15)
        List<List<Integer>> test3 = new ArrayList<>();
        test3.add(Arrays.asList(-10, -20));
        test3.add(Arrays.asList(-5));
        System.out.println("Test 3 (Negatives): " + solution.heaviestListIndex(test3));
        // Expected: 1

        // Test Case 4: Mixed Empty Lists
        // Row 0: {}       -> Ignore
        // Row 1: {0, 0}   -> Weight: 0.0 (Winner by default)
        // Row 2: {}       -> Ignore
        List<List<Integer>> test4 = new ArrayList<>();
        test4.add(new ArrayList<>());
        test4.add(Arrays.asList(0, 0));
        test4.add(new ArrayList<>());
        System.out.println("Test 4 (Empty Rows): " + solution.heaviestListIndex(test4));
        // Expected: 1

        // Test Case 5: Null or entirely empty
        List<List<Integer>> test5 = new ArrayList<>();
        test5.add(new ArrayList<>());
        System.out.println("Test 5 (All empty): " + solution.heaviestListIndex(test5));
        // Expected: -1
    }
}
