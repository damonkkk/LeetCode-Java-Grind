package Review.Q5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A cache that stores key-value pairs with expiration times.
 * Items expire after a certain time and are automatically removed.
 */
public class ExpiringCache<K, V> {

    private static class CacheEntry<K, V> {
        K key;
        V value;
        long expirationTime;  // System.currentTimeMillis() when it expires

        CacheEntry(K key, V value, long ttlMillis) {
            this.key = key;
            this.value = value;
            this.expirationTime = System.currentTimeMillis() + ttlMillis;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expirationTime;
        }
    }

    private Map<K, CacheEntry<K, V>> cache;

    public ExpiringCache() {
        // FIXME: Initialize cache
        cache = new HashMap<>();
    }
    /**
     * Adds key-value pair with time-to-live in milliseconds.
     */
    public void put(K key, V value, long ttlMillis) {
        // FIXME: Implement
        // Create CacheEntry and add to cache
        CacheEntry<K,V> a = new CacheEntry<>(key,value,ttlMillis);
        cache.put(key,a);
    }

    /**
     * Gets value for key, or null if expired or not found.
     */
    public V get(K key) {
        // FIXME: Implement
        // 1. Check if key exists in cache
        // 2. Check if entry is expired
        // 3. If expired, remove it and return null
        // 4. Otherwise return value
        CacheEntry<K,V> entry = cache.get(key);
        if(entry == null){
            return null;
        }
        // Case 2: Found but expired - remove it
        if (entry.isExpired()) {
            cache.remove(key);  // ✓ Just remove(key), not remove(key, value)
            return null;
        }
        // Case 3: Found and valid - return value
        return entry.value;
    }

    /**
     * Returns true if key exists and is not expired.
     */
    public boolean containsKey(K key) {
        // FIXME: Implement
        CacheEntry<K,V> entry = cache.get(key);
        if(entry == null){
            return false;
        }
        if(entry.isExpired()){
            return false;
        }
        return true;
    }

    /**
     * Removes key from cache.
     */
    public V remove(K key) {
        // FIXME: Implement
        CacheEntry<K,V> entry = cache.get(key);

        if(entry==null){
            return null;
        }
        V old = entry.value;
        cache.remove(key);
        return old;

    }

    /**
     * Removes all expired entries from cache.
     * @return number of entries removed
     */
    public int cleanupExpired() {
        // FIXME: Implement
        // Iterate through all entries and remove expired ones
        int removed = 0;

        // Create list of keys to remove (can't remove while iterating)
        List<K> toRemove = new ArrayList<>();

        // Find all expired entries
        for (K key : cache.keySet()) {
            CacheEntry<K, V> entry = cache.get(key);
            if (entry.isExpired()) {
                toRemove.add(key);
            }
        }

        // Remove them
        for (K key : toRemove) {
            cache.remove(key);
            removed++;
        }

        return removed;
    }

    public int size() {
        // FIXME: Should this count expired entries or not?
        int count = 0;
        for (CacheEntry<K, V> entry : cache.values()) {
            if (!entry.isExpired()) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws InterruptedException {
        ExpiringCache<String, String> cache = new ExpiringCache<>();

// Add items with short TTL
        cache.put("item1", "value1", 1000);  // 1 second
        cache.put("item2", "value2", 1000);  // 1 second
        cache.put("item3", "value3", 1000);  // 1 second
        cache.put("long", "stays", 10000);   // 10 seconds

        System.out.println("Initial size: " + cache.size());

// Wait for expiration
        Thread.sleep(2000);

// DON'T access the expired items - let cleanupExpired() find them
        System.out.println("Size before cleanup: " + cache.size());  // Should be 1 if counting valid only

        int removed = cache.cleanupExpired();
        System.out.println("Removed " + removed + " expired entries");  // Should be 3!

        System.out.println("Size after cleanup: " + cache.size());  // Should be 1
        System.out.println("Long still there: " + cache.get("long"));  // "stays"
    }
}