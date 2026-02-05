package Review.Q5;

import java.util.ArrayList;
import java.util.List;

/**
 * Hash table using open addressing with linear probing.
 * Probing: index = (hash(key) + i) % capacity
 */
public class LinearProbingHashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;
        boolean isDeleted;  // For lazy deletion

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private static final int CAPACITY = 11;

    @SuppressWarnings("unchecked")
    public LinearProbingHashTable() {
        // FIXME: Initialize table array and size
        table = (Entry<K, V>[]) new Entry[CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        // FIXME: Implement hash function
        return Math.abs(key.hashCode()) % CAPACITY;
    }

    /**
     * Adds key-value pair using linear probing.
     */
    public void put(K key, V value) {
        // FIXME: Implement linear probing
        // 1. Start at hash(key)
        // 2. If slot is null or deleted, insert here
        // 3. If slot has same key, update value
        // 4. Otherwise, move to next slot: (index + 1) % CAPACITY
        // 5. Repeat until found or table is full

        int index = hash(key);  // Start position
        int startIndex = index;  // Remember where we started to detect full table

        while (true) {
            Entry<K, V> entry = table[index];

            // Case 1: Empty slot - insert new entry
            if (entry == null) {
                table[index] = new Entry<>(key, value);
                size++;
                return;
            }

            // Case 2: Deleted slot - reuse it for new entry
            if (entry.isDeleted) {
                entry.key = key;
                entry.value = value;
                entry.isDeleted = false;  // Mark as active again
                size++;
                return;
            }

            // Case 3: Key already exists - update value
            if (entry.key.equals(key)) {
                entry.value = value;  // Update, don't increase size
                return;
            }

            // Case 4: Collision - move to next slot (linear probing)
            index = (index + 1) % CAPACITY;

            // Check if we've wrapped around (table is full)
            if (index == startIndex) {
                throw new IllegalStateException("Hash table is full");
            }
        }
    }

    /**
     * Gets value for key using linear probing.
     */
    public V get(K key) {
        // FIXME: Implement linear probing search
        // 1. Start at hash(key)
        // 2. If slot is null, key not found
        // 3. If slot has key and not deleted, return value
        // 4. Otherwise, probe next slot
        int idx = hash(key);
        int startidx = idx;

        while (true){
            Entry<K, V> entry = table[idx];
            if(entry==null){
                return null;
            }

            if(entry.key.equals(key)&& !entry.isDeleted ){
                return entry.value;
            }

            idx = (idx + 1) % CAPACITY;

            // Check if we've wrapped around (table is full)
            if (idx == startidx) {
                return null;
            }
        }
    }

    /**
     * Returns true if key exists (and not deleted).
     */
    public boolean containsKey(K key) {
        int idx = hash(key);
        int startidx = idx;

        while (true){
            Entry<K, V> entry = table[idx];

            // Must check null first!
            if (entry == null) {
                return false;  // Hit empty slot, key doesn't exist
            }

            if (entry.key.equals(key) && !entry.isDeleted) {
                return true;
            }

            idx = (idx + 1) % CAPACITY;

            if (idx == startidx) {
                return false;
            }
        }

    }

    /**
     * Removes key using LAZY DELETION.
     */
    public V remove(K key) {
        // FIXME: Implement
        // Mark as deleted, don't set to null!
        int idx = hash(key);
        int startidx = idx;

        while (true){
            Entry<K, V> entry = table[idx];

            if (entry == null) {
                return null;  // Not: entry.isDeleted (that would crash!)
            }

            if (entry.key.equals(key) && !entry.isDeleted) {
                V v = entry.value;
                entry.isDeleted =true;
                size--;                     // ✓ Decrease count
                return v;
            }

            idx = (idx + 1) % CAPACITY;

            if (idx == startidx) {
                return null;
            }
        }
    }

    public int size() {
        return size;
    }
}
