package Review;

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
        // TODO: Write your logic here
        return 0;
    }

    public static void main(String[] args) {
        Q1CountDigits solution = new Q1CountDigits();

        System.out.println("Test 1: " + solution.countDigits("abc123def45")); // Expected: 5
        System.out.println("Test 2: " + solution.countDigits("Hello World"));  // Expected: 0
        System.out.println("Test 3: " + solution.countDigits("1a2b3c"));      // Expected: 3
    }
}