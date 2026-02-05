package Review.Q5;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A key-value store where each entry has a priority.
 * Higher priority entries are retrieved first.
 */
public class PriorityStore<K, V> {

    private static class PriorityEntry<K, V> implements Comparable<PriorityEntry<K, V>> {
        K key;
        V value;
        int priority;

        PriorityEntry(K key, V value, int priority) {
            this.key = key;
            this.value = value;
            this.priority = priority;
        }

        @Override
        public int compareTo(PriorityEntry<K, V> other) {
            // FIXME: Compare by priority (higher priority first)
            return other.priority - this.priority;
        }
    }

    private Map<K, PriorityEntry<K, V>> entries;
    private PriorityQueue<PriorityEntry<K, V>> priorityQueue;

    public PriorityStore() {
        // FIXME: Initialize both data structures
        entries = new HashMap<>();
        priorityQueue = new PriorityQueue<>();
    }

    /**
     * Adds key-value pair with priority.
     * If key exists, updates value and priority.
     */
    public void put(K key, V value, int priority) {
        // FIXME: Implement
        // 1. Check if key already exists
        // 2. If exists, remove old entry from priority queue
        // 3. Create new entry
        // 4. Add to both map and priority queue

        if(entries.containsKey(key)){
            PriorityEntry<K,V> old = entries.get(key);
            priorityQueue.remove(old);

            PriorityEntry<K,V> entry1 = new PriorityEntry<>(key,value,priority);

            entries.put(key,entry1);
            priorityQueue.add(entry1);
        }

        }

    /**
     * Gets value for key, or null if not found.
     */
    public V get(K key) {
        if(entries.containsKey(key)){
            PriorityEntry<K,V> old= entries.get(key);
            return old.value;
        }
        return null;
    }

    /**
     * Returns true if key exists.
     */
    public boolean containsKey(K key) {
        PriorityEntry<K, V> entry = entries.get(key);

        if(entry == null){
            return false;
        }
        return true;
    }

    /**
     * Removes and returns the highest priority entry.
     * @return the value of highest priority entry, or null if empty
     */
    public V pollHighestPriority() {
        // FIXME: Implement
        // 1. Poll from priority queue
        // 2. Remove from map
        // 3. Return value
        PriorityEntry<K, V> entry = priorityQueue.poll();
        if(entry==null){
            return null;
        }
        entries.remove(entry);

        return entry.value;
    }

    /**
     * Peeks at highest priority entry without removing it.
     */
    public V peekHighestPriority() {
        // FIXME: Implement
        PriorityEntry<K, V> entry = priorityQueue.peek();
        if(entry==null){
            return null;
        }
        return entry.value;
    }

    /**
     * Removes specific key.
     */
    public V remove(K key) {
        // FIXME: Implement
        // 1. Get the entry from map
        PriorityEntry<K, V> entry = entries.get(key);

        // 2. If key doesn't exist, return null
        if (entry == null) {
            return null;
        }

        // 3. Remove from both structures
        entries.remove(key);
        priorityQueue.remove(entry);

        // 4. Return the value
        return entry.value;
    }

    public int size() {
        return entries.size();
    }
}
