package Review.Q5;

/**
 * Represents an employee in a company HR system.
 * An employee is uniquely identified by employeeID, name, and department.
 */
public class Employee {
    /**
     * The unique employee ID (a positive integer)
     */
    int employeeID;

    /**
     * The employee's full name (a string of ASCII characters)
     */
    String name;

    /**
     * The employee's department (a string of ASCII characters)
     */
    String department;

    public Employee(int employeeID, String name, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
    }

    /**
     * @return a hash code value for this object.
     * In implementing this method, you may NOT use the default Java
     * implementations in Object.hashCode() or Objects.hash().
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 7;
        result = 13*result+employeeID;
        result = 13*result+ (name == null ? 0 : name.hashCode());
        result= 13 *result+ (department == null ? 0 : department.hashCode());
        return result;
    }

    /**
     * @return a secondary hash code value for use in double hashing collision resolution.
     * This hash code MUST be different from the primary hashCode() method.
     * CRITICAL: This method must NEVER return 0 (to avoid infinite loops in probing).
     * CRITICAL: The return value should be odd (to ensure it's coprime with even table sizes).
     * In implementing this method, you may NOT use the default Java
     * implementations in Object.hashCode() or Objects.hash().
     */
    public int secondaryHashCode() {
        int r = 17;
        r = 31*r +employeeID;
        r= 31*r+(name == null ? 0 : name.hashCode());
        r=31*r+(department == null ? 0 : department.hashCode());
        r= Math.abs(r);
        if(r==0 || r%2==0){
            r++;
        }
        return r;
    }

    /**
     * @return true if this employee is equal to the provided object
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if(this==object){
            return true;
        }
        if(object==null || getClass() != object.getClass()){
            return false;
        }
        Employee damon = (Employee) object;
        return damon.employeeID == employeeID &&
                name.equals(damon.name) &&
                department.equals(damon.department);
    }

    @Override
    public String toString() {
        return "Employee{ID=" + employeeID + ", name='" + name + "', dept='" + department + "'}";
    }


    public static void main(String[] args) {
        System.out.println("=== Testing Employee Hash Functions ===\n");

        Employee e1 = new Employee(1001, "Alice Chen", "Engineering");
        Employee e2 = new Employee(1001, "Alice Chen", "Engineering");
        Employee e3 = new Employee(1002, "Bob Smith", "Marketing");
        Employee e4 = new Employee(1001, "Alice Chen", "Sales");  // Different dept

        // Test 1: Equals
        System.out.println("Test 1: Equals");
        System.out.println("e1.equals(e2): " + e1.equals(e2));  // true
        System.out.println("e1.equals(e3): " + e1.equals(e3));  // false
        System.out.println("e1.equals(e4): " + e1.equals(e4));  // false
        System.out.println();

        // Test 2: Hash consistency (equal objects must have equal hashes)
        System.out.println("Test 2: Hash consistency");
        System.out.println("e1 primary hash: " + e1.hashCode());
        System.out.println("e2 primary hash: " + e2.hashCode());
        System.out.println("Same? " + (e1.hashCode() == e2.hashCode()));  // MUST be true
        System.out.println();

        System.out.println("e1 secondary hash: " + e1.secondaryHashCode());
        System.out.println("e2 secondary hash: " + e2.secondaryHashCode());
        System.out.println("Same? " + (e1.secondaryHashCode() == e2.secondaryHashCode()));  // MUST be true
        System.out.println();

        // Test 3: Different objects (likely different hashes)
        System.out.println("Test 3: Different objects");
        System.out.println("e1 primary: " + e1.hashCode() + ", secondary: " + e1.secondaryHashCode());
        System.out.println("e3 primary: " + e3.hashCode() + ", secondary: " + e3.secondaryHashCode());
        System.out.println("e4 primary: " + e4.hashCode() + ", secondary: " + e4.secondaryHashCode());
        System.out.println();

        // Test 4: Critical properties of secondaryHashCode
        System.out.println("Test 4: Secondary hash properties");
        for (Employee e : new Employee[]{e1, e2, e3, e4}) {
            int secondary = e.secondaryHashCode();
            boolean nonZero = (secondary != 0);
            boolean isOdd = (secondary % 2 == 1);
            System.out.println(e + " secondary=" + secondary +
                    ", nonZero=" + nonZero + ", odd=" + isOdd);
            if (!nonZero || !isOdd) {
                System.out.println("  ❌ FAIL: Secondary hash must be non-zero and odd!");
            }
        }
        System.out.println();

        // Test 5: Two hash functions are different
        System.out.println("Test 5: Two hash functions produce different values");
        for (Employee e : new Employee[]{e1, e2, e3, e4}) {
            int primary = e.hashCode();
            int secondary = e.secondaryHashCode();
            boolean different = (primary != secondary);
            System.out.println(e + " primary=" + primary + ", secondary=" + secondary +
                    ", different=" + different);
            if (!different) {
                System.out.println("  ⚠️  WARNING: Primary and secondary should usually be different");
            }
        }
        System.out.println();

        // Test 6: Null handling
        System.out.println("Test 6: Null field handling");
        Employee e5 = new Employee(2001, null, "HR");
        Employee e6 = new Employee(2002, "Charlie", null);
        System.out.println("e5 (null name): primary=" + e5.hashCode() +
                ", secondary=" + e5.secondaryHashCode());
        System.out.println("e6 (null dept): primary=" + e6.hashCode() +
                ", secondary=" + e6.secondaryHashCode());

        System.out.println("\n=== All tests completed! ===");
    }
}