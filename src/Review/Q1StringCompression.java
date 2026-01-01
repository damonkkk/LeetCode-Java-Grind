package Review;

import java.util.HashMap;

public class Q1StringCompression {

    /**
     * Requirement:
     * Implement a method to perform basic string compression using the
     * counts of repeated characters.
     *
     * Examples:
     * "aabcccccaaa" -> returns "a2b1c5a3"
     * "abc" -> returns "a1b1c1"
     */
    public String compress(String s) {
        if(s==null||s.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i =0; i< s.length();i++){
            if(i+1<s.length() && s.charAt(i) == s.charAt(i+1)){
                count ++;
            }else{
            sb.append(s.charAt(i));
            sb.append(count);
            count = 1;}
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q1StringCompression solution = new Q1StringCompression();


        System.out.println("Test 1: " + solution.compress("aabcccccaaa")); // Expected: "a21bc5a3"
        System.out.println("Test 2: " + solution.compress("abc"));         // Expected: "a1b1c1"
        System.out.println("Test 3: " + solution.compress(""));            // Expected: ""
    }
}