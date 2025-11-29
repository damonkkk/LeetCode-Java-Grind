package arrays;

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         char[] cs = s.toCharArray();
//         char[] ct = t.toCharArray();
//         Arrays.sort(cs);
//         Arrays.sort(ct);
//         if(cs.length != ct.length){
//             return false;
//         }

//        for(int i = 0; i < ct.length;i++){
//         if(cs[i] != ct[i]){
//             return false;
//         }
//        }
//        return true;
//     }
// }

class LC242isAnagram {

    public boolean isAnagram(String s, String t) {
        // 1. Quick check: Anagrams must be the same length
        if (s.length() != t.length()) {
            return false;
        }

        // 2. Create a frequency array for 26 lowercase letters
        // 'a' is index 0, 'z' is index 25
        int[] count = new int[26];

        // 3. Iterate through both strings at once
        for (int i = 0; i < s.length(); i++) {
            // Increment count for char in s
            count[s.charAt(i) - 'a']++;
            // Decrement count for char in t
            count[t.charAt(i) - 'a']--;
        }

        // 4. Check if all counts are zero
        // If s and t are anagrams, the +1s and -1s should cancel out perfectly
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}

