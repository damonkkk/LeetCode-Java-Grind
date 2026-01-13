package Review.Q2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findMaxAndIndex {
    /**
     * Requirement:
     * For each inner list, find the Maximum value and its index within that inner list.
     * Return a List<List<Integer>> formatted as: [maxValue, indexOfMaxValue].
     *
     * Complexity:
     * 1. If multiple elements share the maximum value, return the index of the FIRST occurrence.
     * 2. If the inner list is empty, return [-1, -1].
     */
    public List<List<Integer>> findMaxAndIndex(List<List<Integer>> input) {
        List<List<Integer>> result = new ArrayList<>();
        if(input == null){
            return result;
        }

        for(List<Integer> x: input){
            if(x==null||x.isEmpty()){
                result.add(Arrays.asList(-1,-1));
                //这里需要添加一个continue；不然他就跳到下一个x，会把下一个list的结果添加到这里
                continue;
            }
            // 你最开始写的max=0， 如果整个list都是负数就没办法得到正确答案
            int max = x.get(0);
            // 你最开始写的是x.size-1，这会导致loop不到最后一个，要么<= 和 size-1，要么<和size
            for(int i = 0; i<x.size();i++){
                if(x.get(i) > max){
                    max=x.get(i);
                }
            }
            result.add(Arrays.asList(max,x.indexOf(max)));
            max= 0;
        }

        return result;
    }





    public static void main(String[] args) {
        findMaxAndIndex solution = new findMaxAndIndex();

        // Test Case 1: Standard case (Multiple maxes, empty list, max at start)
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(1, 5, 5)); // Max is 5, first index is 1
        test1.add(new ArrayList<>());      // Empty list
        test1.add(Arrays.asList(10, 2));   // Max is 10, index is 0
        System.out.println("Test 1 (Standard): " + solution.findMaxAndIndex(test1));
        // Expected: [[5, 1], [-1, -1], [10, 0]]

        // Test Case 2: Max at the very end
        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(Arrays.asList(1, 2, 3, 4));
        System.out.println("Test 2 (Max at end): " + solution.findMaxAndIndex(test2));
        // Expected: [[4, 3]]

        // Test Case 3: Negative numbers
        List<List<Integer>> test3 = new ArrayList<>();
        test3.add(Arrays.asList(-10, -5, -20));
        System.out.println("Test 3 (Negatives): " + solution.findMaxAndIndex(test3));
        // Expected: [[-5, 1]]

        // Test Case 4: Single element & All same elements
        List<List<Integer>> test4 = new ArrayList<>();
        test4.add(Arrays.asList(7));
        test4.add(Arrays.asList(8, 8, 8, 8));
        System.out.println("Test 4 (Single/Same): " + solution.findMaxAndIndex(test4));
        // Expected: [[7, 0], [8, 0]]

        // Test Case 5: Null input
        System.out.println("Test 5 (Null): " + solution.findMaxAndIndex(null));
        // Expected: []
    }

}
