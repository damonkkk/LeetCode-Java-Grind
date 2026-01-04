package Leetcode;

import java.util.HashMap;

public class LC387FirstUniqueCharacterinaString {
    class Solution {
        public int firstUniqChar(String s) {
            if(s==null| s.isEmpty()){
                return -1;
            }

            // if(s.length() == 1){
            //     return 0;
            // }


            HashMap<Character,Integer> map = new HashMap<>();
            char[] k = s.toCharArray();

            for(char c:k){
                map.put(c,map.getOrDefault(c,0)+1);
            }

            for(int i = 0; i<=s.length()-1; i++){
                if(map.get(k[i]) == 1){
                    return i;
                }
            }
            return -1;
        }

    }
}
