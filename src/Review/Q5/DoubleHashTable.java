package Review.Q5;

/**
 * A hash table implementation using double hashing for collision resolution.
 * @param <K> the type of keys (must have hashCode() and secondaryHashCode() methods)
 * @param <V> the type of values
 */
public class DoubleHashTable<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 11;

    /**
     * Internal class to store key-value pairs
     */
    private static class Entry<K, V> {
        K key;
        V value;
        boolean isDeleted; // For lazy deletion

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    /**
     * Constructs an empty hash table with default capacity
     */
    @SuppressWarnings("unchecked")
    public DoubleHashTable() {
        // FIXME: Initialize the table
    }

    /**
     * Adds a key-value pair to the hash table.
     * If the key already exists, update its value.
     * Uses double hashing: index = (hash1(key) + i * hash2(key)) % capacity
     *
     * @param key the key (must not be null)
     * @param value the value
     * @throws IllegalArgumentException if key is null
     * @throws IllegalStateException if table is full
     */
    public void add(K key, V value) {
        // FIXME: Implement using double hashing
    }

    /**
     * Checks if the hash table contains the given key.
     * Must use double hashing to probe.
     *
     * @param key the key to search for
     * @return true if key exists and is not deleted, false otherwise
     */
    public boolean contains(K key) {
        // FIXME: Implement using double hashing
        return false;
    }

    /**
     * Gets the value associated with the given key.
     *
     * @param key the key
     * @return the value, or null if key doesn't exist
     */
    public V get(K key) {
        // FIXME: Implement using double hashing
        return null;
    }

    /**
     * Removes a key-value pair from the hash table.
     * Uses LAZY DELETION (marks entry as deleted rather than setting to null).
     *
     * @param key the key to remove
     * @return true if key was found and removed, false otherwise
     */
    public boolean remove(K key) {
        // FIXME: Implement using lazy deletion
        return false;
    }

    /**
     * @return the number of active (non-deleted) entries in the table
     */
    public int size() {
        return size;
    }

    /**
     * @return true if the table has no active entries
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // Helper method: primary hash function
    private int hash1(K key) {
        // FIXME: Implement
        return 0;
    }

    // Helper method: secondary hash function (for step size)
    private int hash2(K key) {
        // FIXME: Implement - must call key's secondaryHashCode() method
        // and ensure result is non-zero
        return 1;
    }
}