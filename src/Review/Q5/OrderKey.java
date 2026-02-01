package Review.Q5;

public class OrderKey {
    int orderID;
    int customerID;
    String date; // Format: "YYYY-MM-DD"

    // All three fields must match for equality

    @Override
    public int hashCode() {
        // Combine all three fields
        return 0;
    }

    public int secondaryHashCode() {
        // Different combination order/weights
        return 0;
    }
}

 class OrderHashTable {
    // Store Order objects keyed by OrderKey
}