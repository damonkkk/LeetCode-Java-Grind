package Review.Q2;

import java.util.*;

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
        List<Integer> result = new ArrayList<>();
        if (input ==null||input.isEmpty()){
            return result;
        }
        int count = 0;
        int sum=0;

        for(List<Integer> row: input){
            if(row==null || row.isEmpty() || row.size() ==1){
                result.add(0);
                continue;
            }
//            for(int i = 0; i<row.size();i++){
//                sum += row.get(i);
//            }
            for(int x:row){
                sum += x;
            }
            // 错误 如果有除法， 一定要用 double
            double average = sum / row.size();
            for(int x: row){
                if(x>average){
                    count++;
                }
            }
            sum = 0;
            result.add(count);
            count =0;
        }


        return result;
    }



//    public List<Integer> countAboveAverage(List<List<Integer>> input) {
//        List<Integer> result = new ArrayList<>();
//        if (input == null) return result;
//
//        for (List<Integer> row : input) {
//            // 边界检查
//            if (row == null || row.isEmpty()) {
//                result.add(0);
//                continue;
//            }
//
//            // 1. 计算总和（用 double 保证后续计算精度）
//            double sum = 0;
//            for (int x : row) {
//                sum += x;
//            }
//
//            // 2. 计算平均值（double 除以 int 会得到 double）
//            double average = sum / row.size();
//
//            // 3. 计算超过平均值的个数
//            int count = 0;
//            for (int x : row) {
//                if (x > average) { // int 和 double 比较时，int 会自动转为 double
//                    count++;
//                }
//            }
//
//            result.add(count);
//        }
//        return result;
//    }
// Test Case: {{10, 20, 30}, {5, 5, 5}, {1, 100}} -> Expected: {1, 0, 1}
// (Row 1 avg=20, only 30 > 20. Row 2 avg=5, none > 5. Row 3 avg=50.5, 100 > 50.5)

    public static void main(String[] args) {
        countAboveAverage solution = new countAboveAverage();

        // Test Case 1: Standard case
        // Row 1: {10, 20, 30} -> Avg: 20.0 -> Above: {30} -> Count: 1
        // Row 2: {5, 5, 5}    -> Avg: 5.0  -> Above: none -> Count: 0
        List<List<Integer>> test1 = new ArrayList<>();
        test1.add(Arrays.asList(10, 20, 30));
        test1.add(Arrays.asList(5, 5, 5));
        System.out.println("Test 1 (Standard): " + solution.countAboveAverage(test1));
        // Expected: [1, 0]

        // Test Case 2: Decimal Averages
        // Row 1: {1, 2} -> Avg: 1.5 -> Above: {2} -> Count: 1
        // Row 2: {1, 100} -> Avg: 50.5 -> Above: {100} -> Count: 1
        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(Arrays.asList(1, 2));
        test2.add(Arrays.asList(1, 100));
        System.out.println("Test 2 (Decimal): " + solution.countAboveAverage(test2));
        // Expected: [1, 1]

        // Test Case 3: Negatives and Mixed
        // Row 1: {-10, -20, -30} -> Avg: -20.0 -> Above: {-10} -> Count: 1
        // Row 2: {0, 0, 0, 10}   -> Avg: 2.5   -> Above: {10}  -> Count: 1
        List<List<Integer>> test3 = new ArrayList<>();
        test3.add(Arrays.asList(-10, -20, -30));
        test3.add(Arrays.asList(0, 0, 0, 10));
        System.out.println("Test 3 (Negatives): " + solution.countAboveAverage(test3));
        // Expected: [1, 1]

        // Test Case 4: Empty and Single Elements
        List<List<Integer>> test4 = new ArrayList<>();
        test4.add(new ArrayList<>());     // Empty
        test4.add(Arrays.asList(100));    // Avg: 100 -> Above: none -> Count: 0
        System.out.println("Test 4 (Empty/Single): " + solution.countAboveAverage(test4));
        // Expected: [0, 0]
    }

}
