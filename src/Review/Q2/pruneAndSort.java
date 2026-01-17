package Review.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
//        List<List<Integer>> res = new ArrayList<>();
//        if(input==null|| input.isEmpty()){
//            return res;
//        }
//        for(List<Integer> list: input){
//            if(list==null || list.isEmpty()){
//                list.add(0);
//                continue;
//            }
//
//            int min = 0;
//            for(int x: list){
//                if(x<min){
//                    list.remove(x);
//                }
//            }
//            Collections.sort(list, Collections.reverseOrder());
//            res.add(list);
//        }
//
//        return res;

            if (input == null) return new ArrayList<>();

            for (List<Integer> list : input) {
                if (list == null) continue;

                // 1. 先删除所有负数 (一步到位，不会报错)
                list.removeIf(n -> n < 0);

                // 2. 删除后再检查是否为空 (处理全是负数的情况)
                if (list.isEmpty()) {
                    list.add(0);
                }

                // 3. 排序 (由大到小)
                Collections.sort(list, Collections.reverseOrder());
            }

            return input; // 直接返回修改后的原 input 即可

    }
// Test Case: {{1, -5, 3}, {-1, -2}, {0, 8}}
// Step 1: {{1, 3}, {}, {0, 8}}
// Step 2: {{1, 3}, {0}, {0, 8}}
// Step 3: {{3, 1}, {0}, {8, 0}} -> Expected result

    public static void main(String[] args) {
        pruneAndSort solution = new pruneAndSort();

        // Test Case 1: Standard Mixed Numbers
        // Row 0: {1, -5, 3} -> Remove -5 -> Sort -> {3, 1}
        // Row 1: {0, 8, -2} -> Remove -2 -> Sort -> {8, 0}
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(new ArrayList<>(Arrays.asList(1, -5, 3)));
        test1.add(new ArrayList<>(Arrays.asList(0, 8, -2)));
        System.out.println("Test 1 (Mixed): " + solution.pruneAndSort(test1));
        // Expected: [[3, 1], [8, 0]]

        // Test Case 2: All Negatives (The "Add 0" Rule)
        // Row 0: {-1, -2, -3} -> All removed -> List empty -> Add 0 -> {0}
        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(new ArrayList<>(Arrays.asList(-1, -2, -3)));
        System.out.println("Test 2 (All Negatives): " + solution.pruneAndSort(test2));
        // Expected: [[0]]

        // Test Case 3: Already Sorted and Zeros
        // Row 0: {10, 5, 0} -> No negatives -> Already sorted -> {10, 5, 0}
        List<List<Integer>> test3 = new ArrayList<>();
        test3.add(new ArrayList<>(Arrays.asList(10, 5, 0)));
        System.out.println("Test 3 (Sorted/Zero): " + solution.pruneAndSort(test3));
        // Expected: [[10, 5, 0]]

        // Test Case 4: Empty Input Row
        // Row 0: {} -> Empty -> Add 0 -> {0}
        List<List<Integer>> test4 = new ArrayList<>();
        test4.add(new ArrayList<>());
        System.out.println("Test 4 (Empty Row): " + solution.pruneAndSort(test4));
        // Expected: [[0]]

        // Test Case 5: Large Gap Sorting
        // Row 0: {1, 100, -50, 50} -> {100, 50, 1}
        List<List<Integer>> test5 = new ArrayList<>();
        test5.add(new ArrayList<>(Arrays.asList(1, 100, -50, 50)));
        System.out.println("Test 5 (Sorting): " + solution.pruneAndSort(test5));
        // Expected: [[100, 50, 1]]
    }
}
