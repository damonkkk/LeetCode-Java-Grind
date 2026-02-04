package Review.Q5;

/**
 * Represents a car in a dealership system.
 */
public class Car {
    String make;       // e.g., "Toyota"
    String model;      // e.g., "Camry"
    int year;          // e.g., 2024

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * Primary hash code for general use.
     * You may NOT use Object.hashCode() or Objects.hash().
     */
    @Override
    public int hashCode() {
        int r = 17;
        r = 31*r +year;
        r= 31*r+make.hashCode();
        r=31*r+model.hashCode();
        return r;
    }

    /**
     * Secondary hash code for double hashing.
     * MUST be different from hashCode().
     * MUST never return 0.
     * SHOULD return odd numbers.
     */
    public int secondaryHashCode() {
        int r = 7;
        r = 17*r +year;
        r= 17*r+make.hashCode();
        r=17*r+model.hashCode();
        r= Math.abs(r);
        if(r==0 || r%2==0){
            r++;
        }
        return r;
    }

    @Override
    public boolean equals(Object other) {
        if(this==other){
            return true;
        }
        if(other== null|| getClass()!=other.getClass()){
            return false;
        }
        Car A = (Car) other;
        return A.year == year &&
                model.equals(A.model) &&
                make.equals(A.make);
    }
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Camry", 2024);
        Car c2 = new Car("Toyota", "Camry", 2024);
        Car c3 = new Car("Honda", "Accord", 2024);

        // Test equals
        System.out.println("c1.equals(c2): " + c1.equals(c2));  // true

        // Test both hash functions
        System.out.println("c1.hashCode(): " + c1.hashCode());
        System.out.println("c1.secondaryHashCode(): " + c1.secondaryHashCode());

        // CRITICAL: Check secondaryHashCode properties
        System.out.println("Secondary is non-zero: " + (c1.secondaryHashCode() != 0));  // true
        System.out.println("Secondary is odd: " + (c1.secondaryHashCode() % 2 == 1));   // true

        // Equal objects should have same hashes
        System.out.println("Same primary hash: " + (c1.hashCode() == c2.hashCode()));           // true
        System.out.println("Same secondary hash: " + (c1.secondaryHashCode() == c2.secondaryHashCode()));  // true

        // Different objects should (likely) have different hashes
        System.out.println("\nDifferent cars:");
        System.out.println("c1 primary: " + c1.hashCode() + ", secondary: " + c1.secondaryHashCode());
        System.out.println("c3 primary: " + c3.hashCode() + ", secondary: " + c3.secondaryHashCode());
    }
}
