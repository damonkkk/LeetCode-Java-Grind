package Leetcode;

public class LC125ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            if(s==null || s.isEmpty()){
                return true;
            }

            // this is i don't fully know
            String a = s.replaceAll("[^a-zA-Z0-9]", "");
            String b = a.toLowerCase();
            char[] arr = b.toCharArray();


            StringBuilder res = new StringBuilder();

            //reverse logic i don't fully know
            for (int i = arr.length - 1; i >= 0; i--){
                res.append(arr[i]);
            }

            char[] arr1 = res.toString().toCharArray();

            for(int i=0; i<arr1.length; i++){
                if(arr[i]!=arr1[i]){
                    return false;
                }
            }
            return true;


        }
    }
}
