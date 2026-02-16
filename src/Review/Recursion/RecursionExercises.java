package Review.Recursion;

/**
 * ============================================================
 *  RECURSION EXERCISES  —  Standard Modern Java (Exam Format)
 *  Workshop 5B
 * ============================================================
 *
 * RULES:
 *   • Every method marked // TODO must be implemented RECURSIVELY
 *     (no loops — for/while/do-while — unless stated otherwise)
 *   • Do NOT change any method signatures
 *   • Run:  javac RecursionExercises.java && java RecursionExercises
 * ============================================================
 */
public class RecursionExercises {

    // ============================================================
    // EXERCISE 1  —  Factorial
    // ============================================================

    /**
     * Returns the factorial of n, defined as:
     *   factorial(1) = 1
     *   factorial(n) = n * factorial(n - 1),  for n > 1
     *
     * You may assume n >= 1.
     *
     * Examples:
     *   1  →  1
     *   2  →  2     (1 * 2)
     *   4  →  24    (1 * 2 * 3 * 4)
     *   6  →  720
     */
    static int factorial(int n) {
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 2;
        }

        return n*factorial(n-1);
    }


    // ============================================================
    // EXERCISE 2  —  Sum of first N positive integers
    // ============================================================

    /**
     * Returns the sum of the first n positive integers: 1 + 2 + ... + n.
     * You may assume n >= 1.
     *
     * Examples:
     *   1  →  1
     *   2  →  3    (1 + 2)
     *   3  →  6    (1 + 2 + 3)
     *   5  →  15
     */
    static int sumPositive(int n) {
        if(n==1){
            return 1;
        }

        return n+sumPositive(n-1);
    }


    // ============================================================
    // EXERCISE 3  —  Sum of integers in an interval [n, m]
    // ============================================================

    /**
     * Returns the sum of all integers from n to m (inclusive).
     * You may assume 1 <= n <= m.
     *
     * Examples:
     *   (2, 2)  →  2
     *   (3, 5)  →  12    (3 + 4 + 5)
     *   (1, 5)  →  15    (same as sumPositive(5))
     *   (9,10)  →  19
     *
     * Hint: think about the base case when n == m.
     */
    static int sumPositiveInterval(int n, int m) {
        int res = 0;
        while (m!=n-1){
            res += m;
            m--;
        }
        return res;
    }


    // ============================================================
    // EXERCISE 4  —  Repeat a string N times
    // ============================================================

    /**
     * Returns a String containing n consecutive copies of str.
     * If n == 0, returns the empty string "".
     * You may assume n >= 0.
     *
     * Examples:
     *   ("wow",      0)  →  ""
     *   ("comp1110", 1)  →  "comp1110"
     *   ("",         3)  →  ""
     *   ("hello",    3)  →  "hellohellohello"
     */
    static String repeat(String str, int n) {
        String res="";
        while(n!=0){
            res+= str;
            n--;
        }
        return res;
    }


    // ============================================================
    // EXERCISE 5  —  Symmetric sequence
    // ============================================================

    /**
     * Returns a String containing a symmetric sequence of integers separated
     * by spaces: descending from n down to 1, then ascending from 1 up to n.
     * You may assume n >= 1.
     *
     * Examples:
     *   1  →  "1 1"
     *   2  →  "2 1 1 2"
     *   3  →  "3 2 1 1 2 3"
     *   5  →  "5 4 3 2 1 1 2 3 4 5"
     *
     * Hint: split into two private helpers —
     *   descending(n): builds "n n-1 ... 1 "   (note trailing space)
     *   ascending(n):  builds "1 2 ... n"       (no trailing space)
     * Then symmetricSequence(n) = descending(n) + ascending(n)
     */
    static String symmetricSequence(int n) {
        return descending(n) + ascending(n);
    }

    // private helper stubs — feel free to rename / add parameters
    private static String descending(int n) {
        String res= "";
        while(n!=0) {
            res+= n;
            res +=" ";
            n--;
        }
        return res;
    }

    private static String ascending(int n) {
        String res= "";
        for(int i =1; i<=n; i++){
            if (i < n) {


            res += i;
            res += " ";
            } else {
                res += i;
            }

        }
        return res;
    }


    // ============================================================
    // EXERCISE 6  —  Logical comparison  (short answer)
    // ============================================================

    /**
     * Analyse the recursive function below WITHOUT running it.
     *
     * static boolean comparison(int a, int b) {
     *     if (b == 0)       return false;
     *     else if (a == 0)  return true;
     *     else              return comparison(a - 1, b - 1);
     * }
     *
     * QUESTION A:
     *   What logical comparison does this function implement?
     *   (i.e., what relation between a and b does it return true for?)
     *   Explain WHY by tracing the recursion.
     *
     * QUESTION B:
     *   How would you implement the OPPOSITE comparison recursively?
     *   Write it below as a method called `oppositeComparison`.
     *
     * YOUR ANSWERS HERE:
     *
     *   A:
     *
     *   B: (implement below)
     */
    static boolean comparison(int a, int b) {
        if (b == 0)       return false;
        else if (a == 0)  return true;
        else              return comparison(a - 1, b - 1);
    }

    static boolean oppositeComparison(int a, int b) {
        if (b == 0)       return true;   // b ran out first (or together) → a >= b
        else if (a == 0)  return false;  // a ran out first → a < b
        else              return oppositeComparison(a - 1, b - 1);
    }


    // ============================================================
    // EXERCISE 7  —  Find next character
    // ============================================================

    /**
     * Returns the index of the FIRST occurrence of ch in str that is
     * STRICTLY AFTER position index.  Returns -1 if not found.
     *
     * If the character occurs at or before index, it is ignored.
     *
     * Examples:
     *   ("",       0, 'a')  →  -1   (empty string)
     *   ("a",      0, 'a')  →  -1   (only at index 0, not after it)
     *   ("bba",    0, 'a')  →  2
     *   ("babab",  0, 'a')  →  1
     *   ("babab",  2, 'a')  →  3
     *   ("korrh",  1, 'o')  →  -1   (only at index 1 exactly, not after)
     *   ("korrho", 1, 'o')  →  5    (another 'o' exists after index 1)
     */
    static int findNextCharacter(String str, int index, char ch) {
        // base case: nothing strictly after index
        if (index + 1 >= str.length()) {
            return -1;
        }
        // check the very next position
        if (str.charAt(index + 1) == ch) {
            return index + 1;
        }
        // not found here — look further right
        return findNextCharacter(str, index + 1, ch);
    }


    // ============================================================
    // ADDITIONAL EXERCISE A  —  Count consonants
    // ============================================================

    /**
     * Returns the number of consonants in str (case-insensitive).
     * A consonant is a letter that is NOT a vowel (a, e, i, o, u).
     * Non-letter characters are neither vowels nor consonants — ignore them.
     *
     * Examples:
     *   ""        →  0
     *   "aeiou"   →  0
     *   "bcdfg"   →  5
     *   "hello"   →  3   (h, l, l are consonants; e, o are vowels)
     *   "COMP"    →  3   (C, M, P are consonants; O is a vowel)
     *   "hi123"   →  1   (only h)
     */
    static int countConsonants(String str) {
//
//
//        if(str == null){
//            return 0;
//        }
//        int total = 0;
//        int idx= 0;
//        while(idx<str.length()) {
//            if (Character.isLetter(str.charAt(idx)) && !isVowel(str.charAt(idx))) {
//                total++;
//            }
//            idx++;
//        }
//
//        return total;

        if (str == null || str.isEmpty()) {
            return 0;
        }
        char first = str.charAt(0);
        String rest = str.substring(1);   // everything after the first character

        if (Character.isLetter(first) && !isVowel(first)) {
            return 1 + countConsonants(rest);   // it's a consonant — count it
        } else {
            return countConsonants(rest);       // vowel or non-letter — skip it
        }

    }

    // helper — you may use this freely
    private static boolean isVowel(char c) {
        char lower = Character.toLowerCase(c);
        return lower == 'a' || lower == 'e' || lower == 'i'
                || lower == 'o' || lower == 'u';
    }


    // ============================================================
    // ADDITIONAL EXERCISE B  —  Reverse a string
    // ============================================================

    /**
     * Returns the reverse of str.
     *
     * Examples:
     *   ""      →  ""
     *   "a"     →  "a"
     *   "abc"   →  "cba"
     *   "racecar" → "racecar"   (palindrome stays the same)
     *   "hello" →  "olleh"
     */
    static String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char first = str.charAt(0);
        String rest = str.substring(1);

        return reverseString(rest) + first;
    }


    // ============================================================
    // ADDITIONAL EXERCISE C  —  Find first uppercase vowel
    // ============================================================

    /**
     * Returns the index of the FIRST uppercase vowel (A, E, I, O, U) in str.
     * Returns -1 if no uppercase vowel exists.
     *
     * Examples:
     *   ""       →  -1
     *   "hello"  →  -1   (no uppercase letters)
     *   "hEllo"  →  1    ('E' at index 1)
     *   "AEiou"  →  0    ('A' at index 0)
     *   "abcEfI" →  3    ('E' at index 3, first one wins)
     */
    static int findFirstUpperCaseVowel(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        char first = str.charAt(0);

        if (isVowel1(first)) {
            return 0;                                    // found at current front position
        } else {
            int result = findFirstUpperCaseVowel(str.substring(1));
            if (result == -1) return -1;                 // not found anywhere in rest
            return 1 + result;                           // shift index to account for removed char
        }
    }

    // helper — you may use this freely
    private static boolean isVowel1(char lower) {
        return lower == 'A' || lower == 'E' || lower == 'I'
                || lower == 'O' || lower == 'U';
    }


    // ============================================================
    // ADDITIONAL EXERCISE D  —  Find last uppercase vowel
    // ============================================================

    /**
     * Returns the index of the LAST uppercase vowel (A, E, I, O, U) in str.
     * Returns -1 if no uppercase vowel exists.
     *
     * Examples:
     *   ""       →  -1
     *   "hello"  →  -1
     *   "hEllo"  →  1
     *   "AEiou"  →  1    ('E' at index 1 is the last uppercase vowel)
     *   "abcEfI" →  5    ('I' at index 5)
     */
    static int findLastUpperCaseVowel(String str) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        char last = str.charAt(str.length() - 1);
        String rest = str.substring(0, str.length() - 1);

        if (isVowel1(last)) {
            return str.length() - 1;       // found — its index is already correct
        } else {
            return findLastUpperCaseVowel(rest);   // just return directly, no +1
        }




    }


    // ============================================================
    // TEST INFRASTRUCTURE  (do not modify)
    // ============================================================

    static int passed = 0, failed = 0;

    static void testEqual(Object actual, Object expected, String desc) {
        boolean ok = (expected == null && actual == null)
                || (expected != null && expected.equals(actual));
        if (ok) {
            System.out.println("  PASS: " + desc);
            passed++;
        } else {
            System.out.println("  FAIL: " + desc
                    + "\n        expected: " + expected
                    + "\n        actual:   " + actual);
            failed++;
        }
    }

    static void testTrue(boolean actual, String desc) {
        testEqual(actual, true, desc);
    }

    static void testFalse(boolean actual, String desc) {
        testEqual(actual, false, desc);
    }


    // ============================================================
    // TESTS  —  Exercise 1
    // ============================================================
    static void testExercise1() {
        System.out.println("\n=== Exercise 1: factorial ===");
        testEqual(factorial(1), 1,   "factorial(1) = 1  (base case)");
        testEqual(factorial(2), 2,   "factorial(2) = 2");
        testEqual(factorial(4), 24,  "factorial(4) = 24");
        testEqual(factorial(6), 720, "factorial(6) = 720");
        testEqual(factorial(3), 6,   "factorial(3) = 6");
        testEqual(factorial(5), 120, "factorial(5) = 120");
    }


    // ============================================================
    // TESTS  —  Exercise 2
    // ============================================================
    static void testExercise2() {
        System.out.println("\n=== Exercise 2: sumPositive ===");
        testEqual(sumPositive(1),  1,  "sumPositive(1) = 1  (base case)");
        testEqual(sumPositive(2),  3,  "sumPositive(2) = 3");
        testEqual(sumPositive(3),  6,  "sumPositive(3) = 6");
        testEqual(sumPositive(5),  15, "sumPositive(5) = 15");
        testEqual(sumPositive(10), 55, "sumPositive(10) = 55");
    }


    // ============================================================
    // TESTS  —  Exercise 3
    // ============================================================
    static void testExercise3() {
        System.out.println("\n=== Exercise 3: sumPositiveInterval ===");
        testEqual(sumPositiveInterval(1, 1),  1,               "base case: n=m=1");
        testEqual(sumPositiveInterval(2, 2),  2,               "base case: n=m=2");
        testEqual(sumPositiveInterval(3, 5),  12,              "[3,5] = 3+4+5");
        testEqual(sumPositiveInterval(1, 5),  sumPositive(5),  "n=1 behaves like sumPositive(5)");
        testEqual(sumPositiveInterval(3, 7),  25,              "[3,7] = 3+4+5+6+7");
        testEqual(sumPositiveInterval(9, 10), 19,              "[9,10] = 9+10");
    }


    // ============================================================
    // TESTS  —  Exercise 4
    // ============================================================
    static void testExercise4() {
        System.out.println("\n=== Exercise 4: repeat ===");
        testEqual(repeat("wow", 0),       "",                "n=0 → empty string");
        testEqual(repeat("comp1110", 1),  "comp1110",        "n=1 → single copy");
        testEqual(repeat("", 3),          "",                "empty string repeated = empty");
        testEqual(repeat("hello", 3),     "hellohellohello", "n=3");
        testEqual(repeat("ab", 4),        "abababab",        "n=4");
        testEqual(repeat("x", 5),         "xxxxx",           "single char repeated 5 times");
        testEqual(
                repeat("comp1110/1140/6710 ", 5),
                "comp1110/1140/6710 comp1110/1140/6710 comp1110/1140/6710 " +
                        "comp1110/1140/6710 comp1110/1140/6710 ",
                "n=5 with trailing space");
    }


    // ============================================================
    // TESTS  —  Exercise 5
    // ============================================================
    static void testExercise5() {
        System.out.println("\n=== Exercise 5: symmetricSequence ===");
        testEqual(symmetricSequence(1),  "1 1",                          "n=1 (base case)");
        testEqual(symmetricSequence(2),  "2 1 1 2",                      "n=2");
        testEqual(symmetricSequence(3),  "3 2 1 1 2 3",                  "n=3");
        testEqual(symmetricSequence(5),  "5 4 3 2 1 1 2 3 4 5",          "n=5");
        testEqual(symmetricSequence(10), "10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10", "n=10");
    }


    // ============================================================
    // TESTS  —  Exercise 6
    // ============================================================
    static void testExercise6() {
        System.out.println("\n=== Exercise 6: comparison / oppositeComparison ===");

        // comparison(a, b) — verify your answer from the short-answer question
        testFalse(comparison(0, 0), "comparison(0,0) = false");
        testTrue (comparison(0, 1), "comparison(0,1) = true");
        testTrue (comparison(2, 3), "comparison(2,3) = true");
        testFalse(comparison(3, 2), "comparison(3,2) = false");
        testFalse(comparison(3, 3), "comparison(3,3) = false");
        testTrue (comparison(1, 5), "comparison(1,5) = true");

        // oppositeComparison should be the exact opposite
        testTrue (oppositeComparison(0, 0), "oppositeComparison(0,0) = true");
        testFalse(oppositeComparison(0, 1), "oppositeComparison(0,1) = false");
        testFalse(oppositeComparison(2, 3), "oppositeComparison(2,3) = false");
        testTrue (oppositeComparison(3, 2), "oppositeComparison(3,2) = true");
        testTrue (oppositeComparison(3, 3), "oppositeComparison(3,3) = true");
        testFalse(oppositeComparison(1, 5), "oppositeComparison(1,5) = false");
    }


    // ============================================================
    // TESTS  —  Exercise 7
    // ============================================================
    static void testExercise7() {
        System.out.println("\n=== Exercise 7: findNextCharacter ===");
        testEqual(findNextCharacter("",       0, 'a'), -1, "empty string → -1");
        testEqual(findNextCharacter("k",      0, 'b'), -1, "length=1, char absent → -1");
        testEqual(findNextCharacter("c",      0, 'c'), -1, "char only at index 0 (not after) → -1");
        testEqual(findNextCharacter("ko",     0, 'd'), -1, "char not present → -1");
        testEqual(findNextCharacter("korrh",  0, 'e'), -1, "char not present in longer string → -1");
        testEqual(findNextCharacter("kf",     0, 'f'),  1, "char present strictly after index 0 → 1");
        testEqual(findNextCharacter("korrhoho", 0, 'o'), 1, "multiple occurrences, return first after index");
        testEqual(findNextCharacter("korrho", 3, 'o'),  5, "char present before AND after index → 5");
        testEqual(findNextCharacter("korrh",  4, 'o'), -1, "char only before index → -1");
        testEqual(findNextCharacter("korrh",  1, 'o'), -1, "char exactly at index (not after) → -1");
        testEqual(findNextCharacter("korrho", 1, 'o'),  5, "char at index and again after → 5");
        testEqual(findNextCharacter("korrh",  5, 'o'), -1, "index at end of string → -1");
        testEqual(findNextCharacter("babab",  0, 'a'),  1, "babab from 0 → 1");
        testEqual(findNextCharacter("babab",  2, 'a'),  3, "babab from 2 → 3");
    }


    // ============================================================
    // TESTS  —  Additional exercises
    // ============================================================
    static void testAdditional() {
        System.out.println("\n=== Additional A: countConsonants ===");
        testEqual(countConsonants(""),        0, "empty string → 0");
        testEqual(countConsonants("aeiou"),   0, "all vowels → 0");
        testEqual(countConsonants("AEIOU"),   0, "all uppercase vowels → 0");
        testEqual(countConsonants("bcdfg"),   5, "all consonants → 5");
        testEqual(countConsonants("hello"),   3, "hello: h,l,l are consonants");
        testEqual(countConsonants("COMP"),    3, "COMP: C,M,P are consonants");
        testEqual(countConsonants("hi123"),   1, "hi123: only h, digits ignored");
        testEqual(countConsonants("a1b2c3"),  2, "a1b2c3: b and c only");

        System.out.println("\n=== Additional B: reverseString ===");
        testEqual(reverseString(""),        "",        "empty → empty");
        testEqual(reverseString("a"),       "a",       "single char");
        testEqual(reverseString("abc"),     "cba",     "abc → cba");
        testEqual(reverseString("hello"),   "olleh",   "hello → olleh");
        testEqual(reverseString("racecar"), "racecar", "palindrome unchanged");
        testEqual(reverseString("12345"),   "54321",   "digits reversed");

        System.out.println("\n=== Additional C: findFirstUpperCaseVowel ===");
        testEqual(findFirstUpperCaseVowel(""),        -1, "empty → -1");
        testEqual(findFirstUpperCaseVowel("hello"),   -1, "no uppercase → -1");
        testEqual(findFirstUpperCaseVowel("HELLO"),  1, "HELLO: first uppercase vowel is E at index 1");
        testEqual(findLastUpperCaseVowel("HELLO"),   4, "HELLO: last uppercase vowel is O at index 4");

        testEqual(findFirstUpperCaseVowel("AEiou"),    0, "A at index 0 (first wins)");
        testEqual(findFirstUpperCaseVowel("abcEfI"),   3, "E at 3, I at 5 → first is 3");
        testEqual(findFirstUpperCaseVowel("bcdfgI"),   5, "I at index 5");

        System.out.println("\n=== Additional D: findLastUpperCaseVowel ===");
        testEqual(findLastUpperCaseVowel(""),        -1, "empty → -1");
        testEqual(findLastUpperCaseVowel("hello"),   -1, "no uppercase → -1");
        testEqual(findFirstUpperCaseVowel("BCDFG"), -1, "BCDFG: no vowels at all → -1");
        testEqual(findLastUpperCaseVowel("BCDFG"),  -1, "BCDFG: no vowels at all → -1");
        testEqual(findLastUpperCaseVowel("hEllo"),    1, "only one uppercase vowel E at 1");
        testEqual(findLastUpperCaseVowel("AEiou"),    1, "A at 0, E at 1 → last is 1");
        testEqual(findLastUpperCaseVowel("abcEfI"),   5, "E at 3, I at 5 → last is 5");
        testEqual(findLastUpperCaseVowel("IbcdfgA"),  6, "I at 0, A at 6 → last is 6");
    }


    // ============================================================
    // MAIN
    // ============================================================
    public static void main(String[] args) {
        testExercise1();
        testExercise2();
        testExercise3();
        testExercise4();
        testExercise5();
        testExercise6();
        testExercise7();
        testAdditional();

        System.out.println("\n============================================================");
        System.out.println("  Results: " + passed + " passed,  " + failed + " failed");
        System.out.println("============================================================");
    }
}