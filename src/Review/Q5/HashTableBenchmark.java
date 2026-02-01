package Review.Q5;

public class HashTableBenchmark {

    /**
     * Generates an array of random products for testing.
     * @param count number of products to generate
     * @return array of Product objects
     */
    private static Product[] generateProducts(int count) {
        // TODO: Implement this method
        // Create 'count' number of Product objects with random data
        // Return them as an array

        return null; // Replace this with your implementation
    }

    public static void main(String[] args) {
        // Create same dataset
        Product[] products = generateProducts(1000);

        // Test 1: Linear Probing
        LinearProbingHashTable<Product, Integer> linear = new LinearProbingHashTable<>();
        long start1 = System.nanoTime();
        for (Product p : products) linear.add(p, 1);
        long time1 = System.nanoTime() - start1;

        // Test 2: Double Hashing
        DoubleHashTable<Product, Integer> doubleHash = new DoubleHashTable<>();
        long start2 = System.nanoTime();
        for (Product p : products) doubleHash.add(p, 1);
        long time2 = System.nanoTime() - start2;

        // Test 3: Chaining
        ChainingHashTable<Product, Integer> chaining = new ChainingHashTable<>();
        long start3 = System.nanoTime();
        for (Product p : products) chaining.add(p, 1);
        long time3 = System.nanoTime() - start3;

        // Compare and analyze:
        // - Which is fastest?
        // - How do they perform with high load factor (0.9)?
        // - Which handles deletions best?
    }
}