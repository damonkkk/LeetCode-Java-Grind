package Review.Q5;

public class Course {
    String courseCode;
    String courseName;
    int credits;

    // Implement: hashCode(), secondaryHashCode()
}

class ResizableDoubleHashTable<K, V> {
    private static final double LOAD_FACTOR_THRESHOLD = 0.7;

    // Implement: automatic resizing when load factor > 0.7
    private void resize() {
        // Create new table with ~2x capacity (use next prime number)
        // Rehash all non-deleted entries
    }
}