package Review.Q1;

import java.util.HashMap;

public class Q1FirstUniqueCharacter {

    /**
     * Requirement:
     * Given a string s, find the first non-repeating character in it
     * and return its index. If it does not exist, return -1.
     *
     * Examples:
     * "leetcode" -> returns 0 (l is the first unique char)
     * "loveleetcode" -> returns 2 (v is the first unique char)
     * "aabb" -> returns -1
     */
    public int firstUniqChar(String s) {
        if(s==null || s.isEmpty()){
            return -1;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] x =s.toCharArray();
        int threshold = 1;

        for (var y: x ){
            int count = map.getOrDefault(y, 0) + 1;
            map.put(y, count);
        }

        for(int i = 0; i <= x.length-1;i++){
            if(map.get(x[i])==threshold){
                return i;
            }
        }





        
        return -1;
    }

    public static void main(String[] args) {
        Q1FirstUniqueCharacter solution = new Q1FirstUniqueCharacter();

        System.out.println("Test 1: " + solution.firstUniqChar("leetcode"));     // Expected: 0
        System.out.println("Test 2: " + solution.firstUniqChar("loveleetcode")); // Expected: 2
        System.out.println("Test 3: " + solution.firstUniqChar("aabb"));         // Expected: -1
    }
}