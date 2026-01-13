package Review.Q2;

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
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//
//        int oddSum = 0;
//        int evenSum = 0;
//        for(int i = 0; i<=input.size()-1; i++){
//            if(input.get(i) == null || input.get(i).isEmpty()){
//                result.add(Arrays.asList(0,0));
//                continue;
//            }
//            for(int j = 0; j<=input.get(i).size()-1;j++){
//                if(input.get(i).get(j) %2 == 0){
//                    evenSum += input.get(i).get(j);
//                } else {
//                    oddSum += input.get(i).get(j);
//                }
//            }
//            result.add(Arrays.asList(evenSum,oddSum));
//            evenSum =0;
//            oddSum=0;
//
//        }
//
//        return result;

        List<List<Integer>> result = new ArrayList<>();

        if (input == null) {
            return result;
        } // Safety check

        for (List<Integer> subList : input) {
            int evenSum = 0;
            int oddSum = 0;

            // Check if subList exists (handle null inner lists)
            if (subList != null) {
                for (Integer num : subList) {
                    if (num == null) continue; // Handle potential nulls inside the list

                    if (num % 2 == 0) {
                        evenSum += num;
                    } else {
                        oddSum += num;
                    }
                }
            }

            // This naturally handles empty lists by adding [0, 0]
            result.add(Arrays.asList(evenSum, oddSum));
        }

        return result;
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