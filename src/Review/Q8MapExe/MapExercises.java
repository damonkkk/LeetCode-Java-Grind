package Review.Q8MapExe;

import java.util.*;

/**
 * ============================================================
 *  MAP EXERCISES  —  Standard Modern Java (Exam Format)
 * ============================================================
 *
 * CONVERSION KEY (functional Java → standard Java):
 *   ConsList<Pair<K,V>>   →  ArrayList<Pair<K,V>>   (list-based / "stateless" map)
 *   Map<K,V> / HashMap    →  HashMap<K,V>            (hash-based / "stateful" map)
 *   Nothing<V>            →  null                    (key not found)
 *   Something<V>(x)       →  x                       (key found, value is x)
 *   MakeConsMap(p1,p2..)  →  makeListMap(p1,p2..)
 *   MakeList(a,b,c)       →  makeList(a,b,c)
 *
 * INSTRUCTIONS:
 *   Implement each method marked  // TODO
 *   Do NOT change method signatures.
 *   Run  javac MapExercises.java && java MapExercises  to test.
 * ============================================================
 */
public class MapExercises {

    // ============================================================
    // SETUP: Pair<A,B>  —  generic key-value pair
    // ============================================================
    static class Pair<A, B> {
        final A first;
        final B second;

        Pair(A first, B second) {
            this.first  = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> p = (Pair<?, ?>) o;
            return Objects.equals(first, p.first) && Objects.equals(second, p.second);
        }

        @Override public int    hashCode() { return Objects.hash(first, second); }
        @Override public String toString() { return "(" + first + ", " + second + ")"; }
    }

    // ------ helper: build ArrayList<Pair<K,V>> from varargs ------
    @SafeVarargs
    static <K, V> ArrayList<Pair<K, V>> makeListMap(Pair<K, V>... pairs) {
        ArrayList<Pair<K, V>> m = new ArrayList<>();
        Collections.addAll(m, pairs);
        return m;
    }

    // ------ helper: build a plain ArrayList from varargs ---------
    @SafeVarargs
    static <T> ArrayList<T> makeList(T... items) {
        ArrayList<T> l = new ArrayList<>();
        Collections.addAll(l, items);
        return l;
    }


    // ============================================================
    // EXERCISE 1  (Short Answer — write your answer as a comment)
    // ============================================================
    /*
     * In standard Java, compare these two "put" operations:
     *
     *   (a) List-based map (ArrayList<Pair<K,V>>):
     *         static <K,V> ArrayList<Pair<K,V>> myPut(ArrayList<Pair<K,V>> map, Pair<K,V> entry)
     *
     *   (b) HashMap:
     *         map.put(K key, V value)   // modifies the map in-place, returns old value or null
     *
     * QUESTION:
     *   Why does (a) return a *new* ArrayList while (b) modifies the map in-place?
     *   What does this tell you about mutability and the design of each data structure?
     *
     * YOUR ANSWER HERE:
     *a) generate a new copy with nem element every time while b) appending the new element to the original map
     * hashmap is mutable while a) is not
     */


    // ============================================================
    // EXERCISE 2  —  Count characters in a String
    // ============================================================

    /**
     * Returns an ArrayList-based map that associates each character in str
     * with how often it appears.  Pairs appear in order of first occurrence.
     *
     * Examples:
     *   ""         →  []
     *   "a"        →  [('a', 1)]
     *   "aaab"     →  [('a', 3), ('b', 1)]
     *   "COMP1110" →  [('C',1), ('O',1), ('M',1), ('P',1), ('1',3), ('0',1)]
     */
    static ArrayList<Pair<Character, Integer>> characterCountList(String str) {
        ArrayList<Pair<Character, Integer>> res = new ArrayList<>();
        if (str == null) {
            return res;
        }
        for (char c : str.toCharArray()) {
            boolean found = false;
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).first == c) {           // character already in list
                    res.set(i, new Pair<>(c, res.get(i).second + 1));  // update count
                    found = true;
                    break;
                }
            }
            if (!found) {
                res.add(new Pair<>(c, 1));             // new character, start at 1
            }
        }
        return res;
    }

    /**
     * Returns a HashMap that associates each character in str with its frequency.
     *
     * Same examples as characterCountList.
     */
    static HashMap<Character, Integer> characterCountHash(String str) {

        HashMap<Character,Integer> res = new HashMap<>();
        if(str == null){
            return res;
        }
        for(var c: str.toCharArray()){
            res.put(c,res.getOrDefault(c,0)+1);
        }

        return res;
    }


    // ============================================================
    // EXERCISE 3  —  Is Isogram?
    // ============================================================

    /**
     * Returns true iff str is an isogram: no character appears more than once.
     * Comparison is case-sensitive  ('a' ≠ 'A').
     * The empty string "" is an isogram.
     *
     * Examples:
     *   "abc"      →  true
     *   "aaa"      →  false
     *   "aA"       →  true    (different characters)
     *   "abcdefga" →  false   (repeated 'a')
     *
     * Hint: consider reusing characterCountHash.
     */
    static boolean isIsogram(String str) {
       HashMap<Character,Integer> map = new HashMap<>();
       if(str==null){
           return false;
       }
       for(var c: str.toCharArray()){
           map.put(c,map.getOrDefault(c,0)+1);
       }

       for(var v: map.keySet()){
               if (map.get(v)>1){
                   return false;
               }
       }
        return true;
    }


    // ============================================================
    // EXERCISE 5  —  myGet  for ArrayList-based maps
    //                (Distinction-level)
    // ============================================================

    /**
     * Returns the value associated with key in the list-based map,
     * or null if the key is not present.
     *
     * This mimics HashMap.get() but for ArrayList<Pair<K,V>>.
     *
     * Examples  (map = [("a",1), ("b",2)]):
     *   myGet(map, "a")  →  1
     *   myGet(map, "b")  →  2
     *   myGet(map, "c")  →  null
     */
    static <K, V> V myGet(ArrayList<Pair<K, V>> map, K key) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        for (var pair : map) {
            if (pair.first.equals(key)) {   // value equality, not reference equality
                return pair.second;         // found it — return immediately
            }
            // no else — just move on to the next pair
        }
        return null;
    }


    // ============================================================
    // EXERCISE 6  —  myPut  for ArrayList-based maps
    //                (Distinction-level)
    // ============================================================

    /**
     * Returns a NEW ArrayList-based map with the given pair inserted or updated.
     *   • If key already exists → replace that pair at the same position.
     *   • If key is absent      → append the new pair at the end.
     * The original map must NOT be modified.
     *
     * Examples  (map = [("a",1), ("b",2)]):
     *   myPut(map, ("c",3))  →  [("a",1), ("b",2), ("c",3)]   // new key appended
     *   myPut(map, ("a",5))  →  [("a",5), ("b",2)]             // existing key updated in place
     *   myPut(map, ("b",6))  →  [("a",1), ("b",6)]             // existing key at end updated
     */
    static <K, V> ArrayList<Pair<K, V>> myPut(ArrayList<Pair<K, V>> map, Pair<K, V> entry) {
        ArrayList<Pair<K, V>> res = new ArrayList<>();
        if(map == null || map.isEmpty()){
            res.add(entry);
            return res;
        }


        boolean found = false;
        for (var pair : map) {
            if (pair.first.equals(entry.first)) {
                res.add(new Pair<>(pair.first, entry.second));  // replace value in-place
                found = true;
            } else {
                res.add(pair);
            }
        }

        if (!found) {
            res.add(entry);   // key wasn't in map — append at end
        }

        return res;

    }


    // ============================================================
    // EXERCISE 7  —  Generic inverse map
    //                (Distinction-level)
    // ============================================================

    /**
     * Given a list-based map  ArrayList<Pair<K,V>>, returns the inverse:
     *   ArrayList<Pair<V, ArrayList<K>>>
     *
     * In the result:
     *   • Each distinct value V from the input becomes a key.
     *   • Its associated value is the list of all K keys that mapped to V,
     *     in the order they appeared in the input.
     *   • Entries appear in order of first occurrence of each value V.
     *
     * Example:
     *   input : [('C',1),('O',1),('M',1),('P',1),('1',3),('0',1)]
     *   output: [(1,['C','O','M','P','0']), (3,['1'])]
     *
     * Example:
     *   input : [('a',1),('b',1),('c',1)]
     *   output: [(1,['a','b','c'])]
     */
    static <K, V> ArrayList<Pair<V, ArrayList<K>>> inverseMap(ArrayList<Pair<K, V>> map) {
        ArrayList<Pair<V, ArrayList<K>>> res = new ArrayList<>();

        for (var pair : map) {
            V newKey = pair.second;   // original value becomes the new key
            K newVal = pair.first;    // original key goes into the value list

            // Check if newKey already exists in res
            boolean found = false;
            for (var entry : res) {
                if (entry.first.equals(newKey)) {
                    entry.second.add(newVal);  // already exists — just append to its list
                    found = true;
                    break;
                }
            }

            if (!found) {
                // First time seeing this value — create a new entry with a fresh list
                ArrayList<K> keyList = new ArrayList<>();
                keyList.add(newVal);
                res.add(new Pair<>(newKey, keyList));
            }
        }

        return res;


    }


    // ============================================================
    // TEST INFRASTRUCTURE  (do not modify)
    // ============================================================

    static int passed = 0, failed = 0;

    static void testTrue(boolean result, String desc) {
        if (result) { System.out.println("  PASS: " + desc); passed++; }
        else        { System.out.println("  FAIL: " + desc + "  (expected true, got false)"); failed++; }
    }

    static void testFalse(boolean result, String desc) {
        if (!result) { System.out.println("  PASS: " + desc); passed++; }
        else         { System.out.println("  FAIL: " + desc + "  (expected false, got true)"); failed++; }
    }

    // Strict equality (order matters) — used for HashMap and myPut results
    static <T> void testEqual(T expected, T actual, String desc) {
        if (Objects.equals(expected, actual)) {
            System.out.println("  PASS: " + desc); passed++;
        } else {
            System.out.println("  FAIL: " + desc
                    + "\n        expected: " + expected
                    + "\n        actual:   " + actual);
            failed++;
        }
    }

    // Order-independent equality for list-based maps (map semantics)
    static <K, V> void testListMapEqual(
            ArrayList<Pair<K,V>> expected, ArrayList<Pair<K,V>> actual, String desc) {
        boolean ok = actual != null
                && expected.size() == actual.size()
                && actual.containsAll(expected)
                && expected.containsAll(actual);
        if (ok) { System.out.println("  PASS: " + desc); passed++; }
        else    { System.out.println("  FAIL: " + desc
                + "\n        expected: " + expected
                + "\n        actual:   " + actual); failed++; }
    }

    // Outer list order-independent; inner key-list order matters
    static <K, V> void testInverseMapEqual(
            ArrayList<Pair<V, ArrayList<K>>> expected,
            ArrayList<Pair<V, ArrayList<K>>> actual,
            String desc) {
        if (actual == null || expected.size() != actual.size()) {
            System.out.println("  FAIL: " + desc
                    + "\n        expected: " + expected
                    + "\n        actual:   " + actual);
            failed++;
            return;
        }
        for (Pair<V, ArrayList<K>> ep : expected) {
            boolean found = false;
            for (Pair<V, ArrayList<K>> ap : actual) {
                if (Objects.equals(ep.first, ap.first)
                        && Objects.equals(ep.second, ap.second)) {
                    found = true; break;
                }
            }
            if (!found) {
                System.out.println("  FAIL: " + desc
                        + "\n        expected: " + expected
                        + "\n        actual:   " + actual);
                failed++;
                return;
            }
        }
        System.out.println("  PASS: " + desc);
        passed++;
    }


    // ============================================================
    // EXERCISE 4  —  maxOccurrence
    // ============================================================

    /**
     * Returns the character that appears most frequently in str.
     * If there is a tie, return any one of the tied characters.
     * Assumes str is non-null and non-empty.
     *
     * Examples:
     *   "aaab"     →  'a'
     *   "aabb"     →  'a' or 'b'  (tied — either is acceptable)
     *   "abcdddd"  →  'd'
     *   "a"        →  'a'
     *
     * Hint: reuse characterCountHash, then find the key with the highest value.
     */
    static char maxOccurrence(String str) {
        if(str == null){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();

        for(var c: str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int min = 0;
        char res = 0;
       for(var c: map.keySet()){
           if (map.get(c)>min){
               min = map.get(c);
               res = c;
           }
       }
        return res;
    }


    // ============================================================
    // EXERCISE 5  (WS5 Ex5)  —  areAnagrams
    // ============================================================

    /**
     * Returns true iff s1 and s2 are anagrams of each other.
     * Two strings are anagrams if they contain exactly the same characters
     * with the same frequencies (comparison is case-sensitive).
     *
     * Examples:
     *   "listen",  "silent"   →  true
     *   "hello",   "world"    →  false
     *   "aab",     "baa"      →  true
     *   "abc",     "abcd"     →  false  (different lengths)
     *   "",        ""         →  true
     *   "aA",      "Aa"       →  true   (case-sensitive: 'a' and 'A' kept separate)
     *
     * Hint: reuse characterCountHash on both strings and compare the two maps.
     */
    static boolean areAnagrams(String s1, String s2) {
      if(s1.length() != s2.length()){
          return false;
      }
      HashMap<Character,Integer> map = new HashMap<>();

      for(var c: s1.toCharArray()){
          map.put(c, map.getOrDefault(c,0)+1);
      }
       for(var x: s2.toCharArray()){
           map.put(x,map.getOrDefault(x,0)-1);
       }

       for(var y:map.values()){
           if(y !=0){
               return false;
           }
       }
        return true;
    }


    // ============================================================
    // TESTS  —  Exercise 2
    // ============================================================
    static void testExercise2() {
        System.out.println("\n=== Exercise 2: characterCountList / characterCountHash ===");

        // empty string
        testListMapEqual(makeListMap(), characterCountList(""), "List: empty string");
        testEqual(new HashMap<>(), characterCountHash(""), "Hash: empty string");

        // single character
        testListMapEqual(makeListMap(new Pair<>('a', 1)),
                characterCountList("a"), "List: \"a\"");
        testEqual(new HashMap<>(Map.of('a', 1)),
                characterCountHash("a"), "Hash: \"a\"");

        // repeated character at start
        testListMapEqual(makeListMap(new Pair<>('a', 3), new Pair<>('b', 1)),
                characterCountList("aaab"), "List: \"aaab\"");
        testEqual(new HashMap<>(Map.of('a', 3, 'b', 1)),
                characterCountHash("aaab"), "Hash: \"aaab\"");

        // repeated character split by another
        testListMapEqual(makeListMap(new Pair<>('a', 4), new Pair<>('b', 1)),
                characterCountList("aabaa"), "List: \"aabaa\" (split repeats)");
        testEqual(new HashMap<>(Map.of('a', 4, 'b', 1)),
                characterCountHash("aabaa"), "Hash: \"aabaa\"");

        // all same
        testListMapEqual(makeListMap(new Pair<>('a', 3)),
                characterCountList("aaa"), "List: \"aaa\" (all same)");
        testEqual(new HashMap<>(Map.of('a', 3)),
                characterCountHash("aaa"), "Hash: \"aaa\"");

        // all different
        testListMapEqual(
                makeListMap(new Pair<>('a',1), new Pair<>('b',1), new Pair<>('c',1)),
                characterCountList("abc"), "List: \"abc\" (all different)");
        testEqual(new HashMap<>(Map.of('a',1,'b',1,'c',1)),
                characterCountHash("abc"), "Hash: \"abc\"");

        // COMP1110  ('1' appears 3 times, '0' once)
        testEqual(new HashMap<>(Map.of('C',1,'O',1,'M',1,'P',1,'1',3,'0',1)),
                characterCountHash("COMP1110"), "Hash: \"COMP1110\"");

        // includes spaces
        HashMap<Character,Integer> skoopHash = new HashMap<>();
        skoopHash.put('s',1); skoopHash.put('k',1); skoopHash.put('o',4);
        skoopHash.put('p',2); skoopHash.put('d',1); skoopHash.put('a',1);
        skoopHash.put('w',1); skoopHash.put(' ',2);
        testListMapEqual(
                makeListMap(new Pair<>('s',1), new Pair<>('k',1), new Pair<>('o',4),
                        new Pair<>('p',2), new Pair<>('d',1), new Pair<>('a',1),
                        new Pair<>('w',1), new Pair<>(' ',2)),
                characterCountList("skoop da woop"), "List: \"skoop da woop\"");
        testEqual(new HashMap<>(skoopHash), characterCountHash("skoop da woop"), "Hash: \"skoop da woop\"");
    }


    // ============================================================
    // TESTS  —  Exercise 3
    // ============================================================
    static void testExercise3() {
        System.out.println("\n=== Exercise 3: isIsogram ===");

        testTrue (isIsogram("abc"),      "\"abc\" → true  (all unique)");
        testFalse(isIsogram("aaa"),      "\"aaa\" → false (all same)");
        testTrue (isIsogram("aA"),       "\"aA\"  → true  (case-sensitive: a ≠ A)");
        testFalse(isIsogram("abcdefga"), "\"abcdefga\" → false (repeated 'a' far apart)");
        testTrue (isIsogram("a"),        "\"a\"   → true  (single character)");
        testTrue (isIsogram(""),         "\"\"    → true  (empty string)");
    }


    // ============================================================
    // TESTS  —  Exercise 5
    // ============================================================
    static void testExercise5() {
        System.out.println("\n=== Exercise 5: myGet ===");

        // empty map
        ArrayList<Pair<String,Integer>> map0 = makeListMap();
        testEqual(null, myGet(map0, "any"), "empty map → null");

        // map with one entry
        Pair<String,Integer> p1 = new Pair<>("a", 1);
        ArrayList<Pair<String,Integer>> map1 = makeListMap(p1);
        testEqual(1,    myGet(map1, "a"), "map{a:1} get \"a\" → 1");
        testEqual(null, myGet(map1, "b"), "map{a:1} get \"b\" → null");

        // map with two entries
        Pair<String,Integer> p2 = new Pair<>("b", 2);
        ArrayList<Pair<String,Integer>> map2 = makeListMap(p1, p2);
        testEqual(1,    myGet(map2, "a"), "map{a:1,b:2} get \"a\" → 1");
        testEqual(2,    myGet(map2, "b"), "map{a:1,b:2} get \"b\" → 2");
        testEqual(null, myGet(map2, "c"), "map{a:1,b:2} get \"c\" → null");

        // map with five entries
        Pair<String,Integer> p3 = new Pair<>("c", 3);
        Pair<String,Integer> p4 = new Pair<>("d", 4);
        Pair<String,Integer> p5 = new Pair<>("e", 5);
        ArrayList<Pair<String,Integer>> map5 = makeListMap(p1, p2, p3, p4, p5);
        testEqual(1,    myGet(map5, "a"), "map5 get \"a\" → 1");
        testEqual(3,    myGet(map5, "c"), "map5 get \"c\" → 3");
        testEqual(5,    myGet(map5, "e"), "map5 get \"e\" → 5");
        testEqual(null, myGet(map5, "z"), "map5 get \"z\" → null (missing)");
    }


    // ============================================================
    // TESTS  —  Exercise 6
    // ============================================================
    static void testExercise6() {
        System.out.println("\n=== Exercise 6: myPut ===");

        // insert into empty map
        ArrayList<Pair<String,Integer>> map0 = makeListMap();
        Pair<String,Integer> px = new Pair<>("x", 10);
        testEqual(makeListMap(px), myPut(map0, px), "empty map: insert (\"x\",10)");

        // single-entry map
        Pair<String,Integer> origA = new Pair<>("a", 1);
        ArrayList<Pair<String,Integer>> map1 = makeListMap(origA);

        Pair<String,Integer> newB = new Pair<>("b", 2);
        testEqual(makeListMap(origA, newB), myPut(map1, newB),
                "map{a:1}: insert new key \"b\" → appended at end");

        Pair<String,Integer> updA = new Pair<>("a", 3);
        testEqual(makeListMap(updA), myPut(map1, updA),
                "map{a:1}: update \"a\" → same position, new value");

        // two-entry map
        Pair<String,Integer> origB = new Pair<>("b", 2);
        ArrayList<Pair<String,Integer>> map2 = makeListMap(origA, origB);

        Pair<String,Integer> newC = new Pair<>("c", 3);
        testEqual(makeListMap(origA, origB, newC), myPut(map2, newC),
                "map{a:1,b:2}: insert new key \"c\" → appended");

        Pair<String,Integer> updA2 = new Pair<>("a", 5);
        testEqual(makeListMap(updA2, origB), myPut(map2, updA2),
                "map{a:1,b:2}: update \"a\" at start");

        Pair<String,Integer> updB2 = new Pair<>("b", 6);
        testEqual(makeListMap(origA, updB2), myPut(map2, updB2),
                "map{a:1,b:2}: update \"b\" at end");

        // five-entry map
        Pair<String,Integer> pC = new Pair<>("c", 3);
        Pair<String,Integer> pD = new Pair<>("d", 4);
        Pair<String,Integer> pE = new Pair<>("e", 5);
        ArrayList<Pair<String,Integer>> map5 = makeListMap(origA, origB, pC, pD, pE);

        Pair<String,Integer> newZ = new Pair<>("z", 9);
        testEqual(makeListMap(origA, origB, pC, pD, pE, newZ), myPut(map5, newZ),
                "map5: insert \"z\" → appended at end");

        Pair<String,Integer> updA5 = new Pair<>("a", 10);
        testEqual(makeListMap(updA5, origB, pC, pD, pE), myPut(map5, updA5),
                "map5: update \"a\" at start");

        Pair<String,Integer> updC5 = new Pair<>("c", 30);
        testEqual(makeListMap(origA, origB, updC5, pD, pE), myPut(map5, updC5),
                "map5: update \"c\" in middle");

        Pair<String,Integer> updE5 = new Pair<>("e", 50);
        testEqual(makeListMap(origA, origB, pC, pD, updE5), myPut(map5, updE5),
                "map5: update \"e\" at end");

        // verify original map is unmodified after myPut
        ArrayList<Pair<String,Integer>> beforePut = makeListMap(origA, origB);
        myPut(beforePut, new Pair<>("z", 99));
        testEqual(makeListMap(origA, origB), beforePut,
                "original map must be unchanged after myPut");
    }


    // ============================================================
    // TESTS  —  Exercise 7
    // ============================================================
    static void testExercise7() {
        System.out.println("\n=== Exercise 7: inverseMap ===");

        // empty map → empty inverse
        testInverseMapEqual(makeListMap(),
                inverseMap(makeListMap()),
                "{} → {}");

        // single entry
        testInverseMapEqual(
                makeListMap(new Pair<>(1, makeList('a'))),
                inverseMap(makeListMap(new Pair<>('a', 1))),
                "{'a':1} → {1:['a']}");

        // two keys, two distinct values
        testInverseMapEqual(
                makeListMap(new Pair<>(3, makeList('a')), new Pair<>(1, makeList('b'))),
                inverseMap(makeListMap(new Pair<>('a', 3), new Pair<>('b', 1))),
                "{'a':3,'b':1} → {3:['a'],1:['b']}");

        // multiple keys share same value
        testInverseMapEqual(
                makeListMap(
                        new Pair<>(1, makeList('C','O','M','P','0')),
                        new Pair<>(3, makeList('1'))),
                inverseMap(makeListMap(
                        new Pair<>('C',1), new Pair<>('O',1), new Pair<>('M',1),
                        new Pair<>('P',1), new Pair<>('1',3), new Pair<>('0',1))),
                "{'C':1,'O':1,'M':1,'P':1,'1':3,'0':1} → {1:[C,O,M,P,0],3:[1]}");

        // all keys map to one value
        testInverseMapEqual(
                makeListMap(new Pair<>(1, makeList('a','b','c'))),
                inverseMap(makeListMap(
                        new Pair<>('a',1), new Pair<>('b',1), new Pair<>('c',1))),
                "{'a':1,'b':1,'c':1} → {1:['a','b','c']}");

        // all values distinct → each value maps to a single-element list
        testInverseMapEqual(
                makeListMap(
                        new Pair<>(1, makeList('a')),
                        new Pair<>(2, makeList('b')),
                        new Pair<>(3, makeList('c'))),
                inverseMap(makeListMap(
                        new Pair<>('a',1), new Pair<>('b',2), new Pair<>('c',3))),
                "{'a':1,'b':2,'c':3} → {1:['a'],2:['b'],3:['c']}");

        // mixed: some shared, some unique
        testInverseMapEqual(
                makeListMap(
                        new Pair<>(1, makeList('s','k','d','a','w')),
                        new Pair<>(4, makeList('o')),
                        new Pair<>(2, makeList('p',' '))),
                inverseMap(makeListMap(
                        new Pair<>('s',1), new Pair<>('k',1), new Pair<>('o',4),
                        new Pair<>('p',2), new Pair<>('d',1), new Pair<>('a',1),
                        new Pair<>('w',1), new Pair<>(' ',2))),
                "\"skoop da woop\" freq map inverted");
    }


    // ============================================================
    // MAIN
    // ============================================================
    public static void main(String[] args) {
        testExercise2();
        testExercise3();
        testExercise5();
        testExercise6();
        testExercise7();

        System.out.println("\n============================================================");
        System.out.println("  Results: " + passed + " passed,  " + failed + " failed");
        System.out.println("============================================================");
    }
}
