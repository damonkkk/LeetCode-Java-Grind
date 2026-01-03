package Review.Q1;

public class Q1CountDigits {

    /**
     * Requirement:
     * Given a string, count how many numeric digits (0-9) appear in it.
     *
     * Examples:
     * "abc123def45" -> returns 5
     * "Hello World" -> returns 0
     * "1a2b3c" -> returns 3
     */
    public int countDigits(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        char[] s1 = s.toCharArray();
        int count = 0;

        for(int i = 0; i <=s.length()-1; i++){
            if(Character.isDigit(s1[i])){
                count++;
            }


        }

        return count;
    }

    public static void main(String[] args) {
        Q1CountDigits solution = new Q1CountDigits();

        System.out.println("Test 1: " + solution.countDigits("abc123def45")); // Expected: 5
        System.out.println("Test 2: " + solution.countDigits("Hello World"));  // Expected: 0
        System.out.println("Test 3: " + solution.countDigits("1a2b3c"));      // Expected: 3
    }
}