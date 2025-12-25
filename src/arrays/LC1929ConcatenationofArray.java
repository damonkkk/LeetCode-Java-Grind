package arrays;

public class LC1929ConcatenationofArray {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length * 2 ; i++) {
            while(i<= nums.length-1) {
                result[i] = nums[i];
                result[i+nums.length] = nums[i];
                i++;
            }

        }
        return result;

    }
}





