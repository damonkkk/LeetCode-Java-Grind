package Review.Q5;

public class Person {
    String firstName;
    String lastName;
    int age;
    String email; // Most unique - should have highest weight

    @Override
    public int hashCode() {
        // Weight email most heavily (prime 53)
        // Then lastName (prime 31)
        // Then firstName (prime 17)
        // Age contributes least (prime 7)
        return 0;
    }

    public int secondaryHashCode() {
        // Use different primes: 59, 37, 13, 3
        return 0;
    }
}