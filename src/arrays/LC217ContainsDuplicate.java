package arrays;
import java.util.*;

public class LC217ContainsDuplicate {
// solve by loops
//        public static boolean containsDuplicate(int[] nums) {
//            if(nums == null ){
//                return false;
//            }
//            if(nums.length ==1 ){
//                return false;
//            }
//            Arrays.sort(nums);
//            for(int i = 0; i<nums.length-1;i++){
//                if(nums[i] == nums[i+1]){
//                    return true;
//                } else{
//                    continue;
//                }
//            }
//            return false;
//        }


    // solve by hashing
    public static boolean containsDuplicate(int[] nums) {
        if(nums == null) {
            return false;
        }
        if(nums.length == 1){
            return false;
        }
        if(nums.length ==2 ){
            if(nums[0] == nums[1]){
                return true;
            } else{
                return false;
            }
        }
        Map<Integer,Integer> numMap = new HashMap<>();

        for (int j = 0; j <nums.length; j++){
            if(numMap.containsKey(nums[j])){
               continue;
            } else{
                numMap.put(nums[j], numMap.getOrDefault(nums[j], 0) + 1);
            }
        }


        // find max occurrence
        for(int i = 0; i < nums.length; i++){
            if(numMap.get(nums[i])>=2){
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,14,18,22,22};
        System.out.println(containsDuplicate(nums));
    }
}
