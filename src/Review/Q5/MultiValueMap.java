package Review.Q5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A map that stores multiple values for each key.
 * Similar structure to EventHandler/EventsContainer relationship.
 */
public class MultiValueMap<K, V> {

    private Map<K, List<V>> map;

    public MultiValueMap() {
        // FIXME: Initialize map
        map = new HashMap<>();
    }

    /**
     * Adds value to the list for the given key.
     */
    public void add(K key, V value) {
        // FIXME: Implement
        // 1. Get list for key (or create if doesn't exist)
        // 2. Add value to list
        // 1. Get list for key (or create if doesn't exist)
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        // 2. Add value to list
        List<V> list = map.get(key);
        list.add(value);
    }

    /**
     * Returns all values for the given key.
     * Returns empty list if key not found.
     */
    public List<V> get(K key) {
        // FIXME: Implement

        if(map.containsKey(key)){
            return map.get(key);
        }
        return new ArrayList<>();
    }

    /**
     * Returns true if key has at least one value.
     */
    public boolean containsKey(K key) {
        List<V> list = map.get(key);
        return list != null && !list.isEmpty();
    }

    /**
     * Removes one occurrence of value for the given key.
     * @return true if value was found and removed
     */
    public boolean remove(K key, V value) {
        // FIXME: Implement
        // 1. Get list for key
        // 2. Remove value from list
        // 3. If list becomes empty, remove key from map
        // 1. Get list for key
        List<V> list = map.get(key);

        // If key doesn't exist, return false
        if (list == null) {
            return false;
        }

        // 2. Remove value from list (returns true if found and removed)
        boolean removed = list.remove(value);

        // 3. If list becomes empty, remove key from map
        if (list.isEmpty()) {
            map.remove(key);
        }

        return removed;
    }

    /**
     * Removes all values for the given key.
     * @return list of values that were removed
     */
    public List<V> removeAll(K key) {
        List<V> list = map.get(key);
        if (list == null) {
            return new ArrayList<>();
        }
        map.remove(key);
        return list;

        // FIXME: Implement

    }

    /**
     * Returns total number of values across all keys.
     */
    public int size() {
        // FIXME: Implement
        // Sum up sizes of all lists
        int total = 0;
        for (List<V> list : map.values()) {  // ✓ Iterate over all lists
            total += list.size();
        }
        return total;
    }

    /**
     * Returns number of distinct keys.
     */
    public int keyCount() {
        return map.size();
    }

    public static void main(String[] args) {
        MultiValueMap<String, Integer> grades = new MultiValueMap<>();

        // Add multiple grades for same student
        grades.add("Alice", 85);
        grades.add("Alice", 90);
        grades.add("Alice", 88);
        grades.add("Bob", 92);

        // Get all grades for Alice
        System.out.println("Alice's grades: " + grades.get("Alice"));  // [85, 90, 88]

        // Remove one grade
        grades.remove("Alice", 85);
        System.out.println("After removing 85: " + grades.get("Alice"));  // [90, 88]

        // Size
        System.out.println("Total grades: " + grades.size());  // 3
        System.out.println("Students: " + grades.keyCount());  // 2

        // Remove all
        List<Integer> removed = grades.removeAll("Alice");
        System.out.println("Removed: " + removed);  // [90, 88]
        System.out.println("Total grades now: " + grades.size());  // 1
    }
}
