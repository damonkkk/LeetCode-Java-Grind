package Review;
import java.util.HashMap;

public class Q1MaxCharFrequency {

    /**
     * 题目要求：
     * 给定一个字符串，找出其中出现次数最多的字符的次数。
     * 注意：大小写敏感（'A' != 'a'）。
     *
     * 示例：
     * "aaa" -> 返回 3
     * "aabcA" -> 返回 2 (因为 'a' 出现了 2 次，'b','c','A' 各 1 次)
     */
    public int findMaxOccurrence(String s) {

        if(s==null || s.isEmpty()){
            return  0;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        char[] o =  s.toCharArray();

        for(int i = 0; i <= o.length-1; i++){
            map.put(o[i],0);
        }
        for(int i = 0; i <= o.length-1; i++){
            if(map.containsKey(o[i])){
                map.put(o[i], map.get(o[i])+1);
            }
        }

        int max = 0;
        for(int i = 0; i <= o.length-1;i++){
            if(map.get(o[i])>=max){
                max = map.get(o[i]);
            }
        }


        return max;
    }


    // solution 2
//    public int findMaxOccurrence(String s) {
//        // boundary
//        if (s == null || s.isEmpty()) {
//            return 0;
//        }
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        char[] o = s.toCharArray();
//        int max = 0;
//
//        // 2. one loop
//        for (char c : o) {
//            // map.getOrDefault(x,y)
//            // if there is no such char in our map, we put default value as 0, and then +1
//            int count = map.getOrDefault(c, 0) + 1;
//            map.put(c, count);
//
//            // update the max final return during the counting
//            if (count > max) {
//                max = count;
//            }
//        }
//
//        return max;
//    }

    public static void main(String[] args) {
        Q1MaxCharFrequency solution = new Q1MaxCharFrequency();

        // testing
        String test1 = "aaa";
        String test2 = "aabcA";
        String test3 = "AbcdeA";
        String test4 = "";

        System.out.println("Test 1 Result: " + solution.findMaxOccurrence(test1)); //  3
        System.out.println("Test 2 Result: " + solution.findMaxOccurrence(test2)); //  2
        System.out.println("Test 3 Result: " + solution.findMaxOccurrence(test3)); //  2
        System.out.println("Test 4 Result: " + solution.findMaxOccurrence(test4)); //  0
    }
}