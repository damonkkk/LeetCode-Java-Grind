package Review.Q5;

public class CacheEntry {
    String key;
    Object value;
    long lastAccessTime;

    // Implement: hashCode(), secondaryHashCode()
}

class LRUCache<K, V> {
    private static final int MAX_SIZE = 100;

    // When cache is full:
    // 1. Find least recently used entry
    // 2. Remove it
    // 3. Add new entry
}
