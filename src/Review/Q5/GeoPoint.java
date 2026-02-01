package Review.Q5;

public class GeoPoint {
    double latitude;  // -90 to 90
    double longitude; // -180 to 180

    // Challenge: hash doubles effectively
    // Hint: Use Double.hashCode() for each, then combine

    @Override
    public int hashCode() {
        // FIXME: Need to handle floating-point precision
        return 0;
    }

    public int secondaryHashCode() {
        // FIXME: Different combination of lat/lon
        return 0;
    }
}