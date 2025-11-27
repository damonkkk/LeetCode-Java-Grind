package arrays;

// class Solution{
//     public int[] twoSum(int[]nums, int target){
//         for(int i = 0; i<nums.length;i++){
//             for(int j = i+1; j <nums.length; j++){
//                 if(nums[i] + nums[j]==target){
//                     return new int[]{i,j};
//                 }

//             }
//         }
//         return new int[]{};
//     }
// }

import java.util.HashMap;
import java.util.Map;
class LC001TwoSum {
    public int[] twoSum(int[]nums, int target){
        // set up the new hashmap to store
        Map<Integer,Integer> numMap = new HashMap<>();
        // loop through all ints
        for(int i = 0; i<nums.length; i++){
            // simple expression
            int complement = target - nums[i];
            // if there existing a map that contains the complement of the current
            // number on that list, return the index pair of current number and its
            // complements.
            if(numMap.containsKey(complement)){
                return new int[] {numMap.get(complement),i};
            }
            // if for the complemnt, there has no map exist already, add the current number
            // and its index to the map
            numMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No solution");
    }


    public static void main(String[] args) {
        LC001TwoSum solution = new LC001TwoSum();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
    }

}