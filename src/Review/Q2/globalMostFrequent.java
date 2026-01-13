package Review.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class globalMostFrequent {

    /**
     * Requirement:
     * Find the integer that appears most frequently across ALL inner lists combined.
     * Return that integer. If there is a tie, return the smallest integer.
     *
     * Complexity:
     * You must iterate through the entire nested structure and maintain a global count.
     */
    public int globalMostFrequent(List<List<Integer>> input) {
        if(input==null || input.isEmpty()){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(List<Integer> list: input){
            for(int x: list){
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }
        int maxFreq = -1;
        int result =0;

        for (int num : map.keySet()) {
            int currentFreq = map.get(num);
            // 情况 A：发现了一个出现次数更多的数字
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                result = num;
            }
            // 情况 B：平局（出现次数一样多）
            else if (currentFreq == maxFreq) {
                // 根据题目要求：取较小的那个数字
                if (num < result) {
                    result = num;
                }
            }
        }


        return result;
    }
// Test Case: {{1, 2}, {2, 3}, {1, 1}} -> Expected: 1 (appears 3 times)


    public static void main(String[] args) {
        globalMostFrequent solution = new globalMostFrequent();

        // Test Case 1: Standard Case (Tie-break needed)
        // 1 appears 3 times, 2 appears 3 times. Both are max.
        // Smallest is 1.
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(1, 2, 3));
        test1.add(Arrays.asList(1, 2, 1));
        test1.add(Arrays.asList(2, 4));
        System.out.println("Test 1 (Tie-break): " + solution.globalMostFrequent(test1));
        // Expected: 1

        // Test Case 2: Negative Numbers
        // -5 appears 2 times, 10 appears 1 time.
        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(Arrays.asList(-5, 10, -5));
        test2.add(Arrays.asList(0, 1));
        System.out.println("Test 2 (Negatives): " + solution.globalMostFrequent(test2));
        // Expected: -5

        // Test Case 3: All Unique Numbers
        // Every number appears once. Smallest is -10.
        List<List<Integer>> test3 = new ArrayList<>();
        test3.add(Arrays.asList(10, 20));
        test3.add(Arrays.asList(5, -10));
        System.out.println("Test 3 (All Unique): " + solution.globalMostFrequent(test3));
        // Expected: -10

        // Test Case 4: Empty Inner Lists
        List<List<Integer>> test4 = new ArrayList<>();
        test4.add(new ArrayList<>());
        test4.add(Arrays.asList(99, 99));
        test4.add(new ArrayList<>());
        System.out.println("Test 4 (Empty Rows): " + solution.globalMostFrequent(test4));
        // Expected: 99

        // Test Case 5: Null or Empty Input
        System.out.println("Test 5 (Null): " + solution.globalMostFrequent(null));
        // Expected: 0
    }
}
