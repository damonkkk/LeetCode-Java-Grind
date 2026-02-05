package Review.Q5;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple key-value store that maintains insertion order.
 * Uses linear search - no hashing yet.
 */
public class SimpleStore<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key=key;
            this.value=value;
        }
    }

    private List<Entry<K, V>> entries;

    public SimpleStore() {
        //什么意思 就是初始化上面这个东西 因为是list of entry， 所以 new array list
        this.entries = new ArrayList<>();
        // FIXME: Initialize entries list
    }

    /**
     * Adds a key-value pair. If key exists, updates the value.
     * @return the old value if key existed, null otherwise
     */
    public V put(K key, V value) {
        // 要求1 serach： for loop find the key, since it is not primitive, so use .equals()\
        // condition 2: return old value and update new value; so save old value then update new
        //3 not found, null

        for(Entry<K,V> entry : this.entries){
            if(entry.key.equals(key) ){
                V old = entry.value;
                entry.value=value;
                return old;
            }
        }
        // add the new key-value pair to the list of entry
        entries.add(new Entry<>(key,value));
        // FIXME: Implement
        // 1. Search for key in entries list
        // 2. If found, update value and return old value
        // 3. If not found, add new Entry to list
        return null;
    }

    /**
     * Returns the value for the given key, or null if not found.
     */
    public V get(K key) {
        // FIXME: Implement
        // Loop through entries, find matching key
        for(Entry<K,V> entry:entries){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    /**
     * Returns true if the key exists in the store.
     */
    public boolean containsKey(K key) {
        // FIXME: Implement
        for(Entry<K,V>entry : entries){
            if(entry.key.equals(key)){
                return true;
            }
        }
        return  false;

    }

    /**
     * Removes the key-value pair for the given key.
     * @return the value that was removed, or null if key not found
     */
    public V remove(K key) {
        // FIXME: Implement
        // 1. Find the entry with matching key
        // 2. Remove it from list
        // 3. Return its value
        for(Entry<K,V> entry:entries){
            if(entry.key.equals(key)){
                V old = entry.value;
                entries.remove(entry);
                return old;

            }
        }
        return null;
    }

    public int size() {
        return entries.size();
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }


    public static void main(String[] args) {
        SimpleStore<String, Integer> store = new SimpleStore<>();

        // Test put
        store.put("Alice", 85);
        store.put("Bob", 90);
        System.out.println("Size: " + store.size());  // Expected: 2

        // Test get
        System.out.println("Alice's score: " + store.get("Alice"));  // Expected: 85

        // Test update
        Integer oldValue = store.put("Alice", 95);
        System.out.println("Old value: " + oldValue);  // Expected: 85
        System.out.println("New value: " + store.get("Alice"));  // Expected: 95
        System.out.println("Size: " + store.size());  // Expected: 2 (not 3!)

        // Test contains
        System.out.println("Contains Bob: " + store.containsKey("Bob"));  // Expected: true
        System.out.println("Contains Charlie: " + store.containsKey("Charlie"));  // Expected: false

        // Test remove
        Integer removed = store.remove("Bob");
        System.out.println("Removed value: " + removed);  // Expected: 90
        System.out.println("Size after remove: " + store.size());  // Expected: 1
    }
}
