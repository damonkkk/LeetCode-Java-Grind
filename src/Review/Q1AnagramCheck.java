package Review;

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
    public boolean isAnagram(String s, String t) {
        // TODO: Write your logic here
        return false;
    }

    public static void main(String[] args) {
        Q1AnagramCheck solution = new Q1AnagramCheck();

        System.out.println("Test 1: " + solution.isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println("Test 2: " + solution.isAnagram("rat", "car"));         // Expected: false
        System.out.println("Test 3: " + solution.isAnagram("a", "ab"));            // Expected: false
    }
}