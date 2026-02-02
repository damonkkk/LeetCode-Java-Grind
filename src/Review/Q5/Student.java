package Review.Q5;

public class Student {
    int studentID;
    String name;
    String major;

    public Student(int StudentID, String name, String major){
        this.studentID =StudentID;
        this.name=name;
        this.major=major;
    }

    @Override
    public int hashCode(){
        int result = 7;
        result = 13*result+studentID;
        result = 13*result+name.hashCode();
        result = 13 * result+major.hashCode();
        result = Math.abs(result);
        if(result ==0 || result%2 == 0){
            result++;
        }
        return result;
    }
    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Student student = (Student) other;
        return studentID == student.studentID &&
                name.equals(student.name) &&
                major.equals(student.major);
    }
    }



 class LinearProbingHashTable<K, V> {


         // Inner class to hold key-value pairs
         private static class Entry<K, V> {
             K key;
             V value;
             boolean isDeleted;

             Entry(K key, V value) {
                 this.key = key;
                 this.value = value;
                 this.isDeleted = false;
             }
         }

         // The table array and size counter
         private Entry<K, V>[] table;
         private int size;
         private static final int DEFAULT_CAPACITY = 11;

         // Constructor to initialize the table
         @SuppressWarnings("unchecked")
         public LinearProbingHashTable() {
             table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
             size = 0;
         }

         // Hash function - converts key to index
         private int hash(K key) {
             return Math.abs(key.hashCode()) % table.length;
         }

         /**
          * Adds a key-value pair to the hash table.
          * If key exists, updates its value.
          * Uses linear probing: index = (hash(key) + i) % capacity
          */
         public void add(K key, V value) {
             if (key == null) {
                 throw new IllegalArgumentException("Key cannot be null");
             }

             int index = hash(key);
             int probeCount = 0;

             // Linear probing: try index, index+1, index+2, ...
             while (probeCount < table.length) {
                 // Case 1: Empty slot - insert here
                 if (table[index] == null) {
                     table[index] = new Entry<>(key, value);
                     size++;
                     return;
                 }

                 // Case 2: Deleted slot - can reuse
                 if (table[index].isDeleted) {
                     table[index] = new Entry<>(key, value);
                     size++;
                     return;
                 }

                 // Case 3: Key already exists - update value
                 if (table[index].key.equals(key)) {
                     table[index].value = value;
                     // Don't increment size!
                     return;
                 }

                 // Case 4: Collision - probe next slot
                 index = (index + 1) % table.length;
                 probeCount++;
             }

             // Table is full
             throw new IllegalStateException("Hash table is full");
         }

         /**
          * Checks if the hash table contains the given key.
          */
         public boolean contains(K key) {
             if (key == null) return false;

             int index = hash(key);
             int probeCount = 0;

             while (probeCount < table.length) {
                 // Empty slot - key not found
                 if (table[index] == null) {
                     return false;
                 }

                 // Found the key (and it's not deleted)
                 if (!table[index].isDeleted && table[index].key.equals(key)) {
                     return true;
                 }

                 // Continue probing (skip deleted entries)
                 index = (index + 1) % table.length;
                 probeCount++;
             }

             return false;
         }

         /**
          * Gets the value associated with the given key.
          * Returns null if key doesn't exist.
          */
         public V get(K key) {
             if (key == null) return null;

             int index = hash(key);
             int probeCount = 0;

             while (probeCount < table.length) {
                 // Empty slot - key not found
                 if (table[index] == null) {
                     return null;
                 }

                 // Found the key (and it's not deleted)
                 if (!table[index].isDeleted && table[index].key.equals(key)) {
                     return table[index].value;
                 }

                 // Continue probing
                 index = (index + 1) % table.length;
                 probeCount++;
             }

             return null;
         }

         /**
          * Removes a key-value pair from the hash table.
          * Uses LAZY DELETION - marks entry as deleted.
          */
         public boolean remove(K key) {
             if (key == null) return false;

             int index = hash(key);
             int probeCount = 0;

             while (probeCount < table.length) {
                 // Empty slot - key not found
                 if (table[index] == null) {
                     return false;
                 }

                 // Found the key (and it's not already deleted)
                 if (!table[index].isDeleted && table[index].key.equals(key)) {
                     table[index].isDeleted = true;  // Lazy deletion
                     size--;
                     return true;
                 }

                 // Continue probing
                 index = (index + 1) % table.length;
                 probeCount++;
             }

             return false;
         }

         /**
          * Returns the number of active (non-deleted) entries.
          */
         public int size() {
             return size;
         }

         /**
          * Returns true if the table has no active entries.
          */
         public boolean isEmpty() {
             return size == 0;
         }

         /**
          * Prints the table contents for debugging.
          */
         public void printTable() {
             System.out.println("=== Hash Table Contents ===");
             for (int i = 0; i < table.length; i++) {
                 if (table[i] == null) {
                     System.out.println(i + ": [empty]");
                 } else if (table[i].isDeleted) {
                     System.out.println(i + ": [deleted] " + table[i].key);
                 } else {
                     System.out.println(i + ": " + table[i].key + " -> " + table[i].value);
                 }
             }
             System.out.println("Size: " + size);
         }
     }
