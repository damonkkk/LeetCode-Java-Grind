package Review;

import java.util.Arrays;
import java.util.HashMap;

public class Q1AnagramCheck {

    /**
     * Requirement:
     * Given two strings s and t, return true if t is an anagram of s,
     * and false otherwise. (An Anagram contains the same characters
     * with the same frequency).
     *
     * Examples:
     * s = "anagram", t = "nagaram" -> returns true
     * s = "rat", t = "car" -> returns false
     */
//    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//        char[] s1 = s.toCharArray();
//        char[] t1 = t.toCharArray();
//        Arrays.sort(s1);
//        Arrays.sort(t1);
//
//        for(int i =0; i<s1.length; i++){
//            if (s1[i] != t1[i]){
//                return false;
//            }
//        }
//
//        return true;
//    }

    // HashMap WAY
//    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//        HashMap<Character,Integer> map1 = new HashMap<>();
//        char[] s1 = s.toCharArray();
//        char[] t1 = t.toCharArray();
//
//
//
//        for(int i=0; i <s1.length-1; i++){
//            int count = map1.getOrDefault(s1[i],0)+1;
//            map1.put(s1[i],count);
//            int minus = map1.getOrDefault(t1[i],0)-1;
//            map1.put(t1[i],minus);
//        }
//
//        for(int i=0; i < s1.length-1; i++){
//            if(map1.get(s1[i]) != 0){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // 1. 第一步：加法 - 统计第一个字符串
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. 第二步：减法 - 消耗第二个字符串
        for (char c : t.toCharArray()) {
            // 如果 t 里的字符在 map 里根本不存在，说明它多出了字符
            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);

            // 可选优化：如果次数变成负数，说明 t 里这个字符比 s 多
//            if (map.get(c) < 0) {
//                return false;
//            }
        }

        // 3. 第三步：最后检查是否所有值都回到了 0
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Q1AnagramCheck solution = new Q1AnagramCheck();

        System.out.println("Test 1: " + solution.isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println("Test 2: " + solution.isAnagram("rat", "car"));         // Expected: false
        System.out.println("Test 3: " + solution.isAnagram("a", "ab"));            // Expected: false
    }
}