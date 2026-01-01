package Review;

import java.util.HashMap;

public class Q1MajorityElement {

    /**
     * Requirement:
     * Given an array of integers, find the majority element.
     * The majority element is the element that appears more than n/2 times.
     *
     * Examples:
     * [3, 2, 3] -> returns 3
     * [2, 2, 1, 1, 1, 2, 2] -> returns 2
     */
    public int findMajority(int[] nums) {
        if(nums==null){
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int result = 0;
        for (int c: nums){
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) >= max){
                max = map.get(c);
            }
        }
        for (int i = 0; i <nums.length-1;i++){
            if(map.get(nums[i])>map.get(nums[i+1])){
                result = nums[i];
            }
        }


        return result;



    }

    public static void main(String[] args) {
        Q1MajorityElement solution = new Q1MajorityElement();

        int[] test1 = {3, 2, 3};
        int[] test2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Test 1 Result: " + solution.findMajority(test1)); // Expected: 3
        System.out.println("Test 2 Result: " + solution.findMajority(test2)); // Expected: 2
    }
}
