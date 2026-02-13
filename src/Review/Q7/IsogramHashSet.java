package Review.Q7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsogramHashSet {

    public static boolean isIsogram(String str) {
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        char[] arr = str.toCharArray();
//
//        for(Character c: arr){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        int max = 1;
//        for(int count: map.values() ){
//            if (count>max){
//                return false;
//            }
//        }
//        return true;
//    }

        // HashSet Solution

        if (str==null || str.isEmpty()){
        return false;
        }

        HashSet<Character> set = new HashSet<>();
        // 历遍每一个 char of str
        for(Character c: str.toCharArray()){
            //如果 set已经包含了 这个char，那么就是重复了 return false
            if(set.contains(c)){
                return false;
            }
            //如果set未包含这个char 没重复， set 添加这个char， 以防后面的char会与当前char重复
            set.add(c);
        }
        // 其他情况 return true
        return true;
    }
}