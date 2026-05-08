package Leetcode;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC128LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {

            Set<Integer> num = new HashSet<>();
            for(int x: nums){
                num.add(x);
            }

            int longestStreak = 0;


            for (int x: num){
                if(!num.contains(x-1)){
                    int currentNum = x;
                    int currentStreak =1;


                    while(num.contains(x+1)){
                        currentNum +=1;
                        currentStreak +=1;
                    }
                    longestStreak = Math.max(currentStreak,longestStreak);
                }

            }

            return longestStreak;

        }
    }
}
