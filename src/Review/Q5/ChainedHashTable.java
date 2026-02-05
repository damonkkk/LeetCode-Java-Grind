package Review.Q5;

import java.util.ArrayList;
import java.util.List;

/**
 * A hash table using separate chaining (ArrayList in each bucket).
 */
public class ChainedHashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K, V>>[] buckets;
    private int size;
    private static final int CAPACITY = 11;

    @SuppressWarnings("unchecked")
    public ChainedHashTable() {
        buckets = (List<Entry<K, V>>[]) new ArrayList[CAPACITY];
        // Initialize each bucket as empty ArrayList
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new ArrayList<>();
        }
        size = 0;
    }

    /**
     * Hash function to determine bucket index.
     */
    private int hash(K key) {
        // FIXME: Implement
        // Use key.hashCode() and map to [0, CAPACITY)
        return Math.abs(key.hashCode()) % CAPACITY;
    }

    /**
     * Adds key-value pair. Updates if key exists.
     */
    public void put(K key, V value) {
        // FIXME: Implement
        // 1. Calculate bucket index using hash()
        // 2. Get the bucket (ArrayList)
        // 3. Search for key in bucket
        // 4. If found, update value
        // 5. If not found, add new Entry to bucket and increment size
        // Step 1: Find which bucket this key belongs to
        int bucketIndex = hash(key);

        // Step 2: Get that bucket (it's an ArrayList)
        List<Entry<K, V>> bucket = buckets[bucketIndex];

        // Step 3: Search if key already exists in this bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found! Update its value
                entry.value = value;
                return;  // Done! Don't add duplicate
            }
        }

        // Step 4: Key not found, add new entry
        bucket.add(new Entry<>(key, value));
        size++;  // We added a new entry, increase size
    }

    /**
     * Returns value for key, or null if not found.
     */
    public V get(K key) {
        // FIXME: Implement
        // 1. Calculate bucket index
        // 2. Search in that bucket's ArrayList
        // Step 1: Find which bucket this key belongs to
        int bucketIndex = hash(key);

        // Step 2: Get that bucket (it's an ArrayList)
        List<Entry<K, V>> bucket = buckets[bucketIndex];

        // Step 3: Search if key already exists in this bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found! Update its value
                return entry.value;  // Done! Don't add duplicate
            }
        }

       return null;
    }

    /**
     * Returns true if key exists.
     */
    public boolean containsKey(K key) {
        // Step 1: Find which bucket this key belongs to
        int bucketIndex = hash(key);

        // Step 2: Get that bucket (it's an ArrayList)
        List<Entry<K, V>> bucket = buckets[bucketIndex];

        // Step 3: Search if key already exists in this bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found! Update its value
                return true;  // Done! Don't add duplicate
            }
        }

        return false;
    }

    /**
     * Removes key-value pair.
     * @return value that was removed, or null
     */
    public V remove(K key) {
        // FIXME: Implement
        // 1. Find bucket
        // 2. Search for entry in bucket
        // 3. Remove it and decrement size
        // Step 1: Find which bucket this key belongs to
        int bucketIndex = hash(key);

        // Step 2: Get that bucket (it's an ArrayList)
        List<Entry<K, V>> bucket = buckets[bucketIndex];

        // Step 2: Search and remove
        for (int i = 0; i < bucket.size(); i++) {
            Entry<K, V> entry = bucket.get(i);
            if (entry.key.equals(key)) {
                // Found it! Remove and return value
                V removedValue = entry.value;
                bucket.remove(i);  // Remove from ArrayList
                size--;  // Decrease total size
                return removedValue;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
