package Review.Q5;

/**
 * Represents a person with ID, name, and age.
 */
public class Person {
    int personID;
    String name;
    int age;

    public Person(int personID, String name, int age) {
        this.personID = personID;
        this.name = name;
        this.age = age;
    }

    /**
     * @return a hash code value for this object.
     * You may NOT use Object.hashCode() or Objects.hash().
     * IMPORTANT: For String fields, you CAN use name.hashCode()
     */
    @Override
    public int hashCode() {
        int result = 7;
        result = 13*result+personID;
        result = 13*result+name.hashCode();
        result= 13 *result+age;
        return result;
    }

    /**
     * @return true if this person equals the provided object
     */
    @Override
    public boolean equals(Object other) {
        if(this == other){
            return true;
        }
        if(other == null|| getClass() != other.getClass()){
            return false;
        }
        Person person = (Person) other;
        return person.personID == personID &&
                person.age == age &&
                name.equals(person.name);
    }

    public static void main(String[] args) {
        Person p1 = new Person(101, "Alice", 25);
        Person p2 = new Person(101, "Alice", 25);
        Person p3 = new Person(101, "Bob", 25);

        System.out.println("p1.equals(p2): " + p1.equals(p2));  // true
        System.out.println("p1.equals(p3): " + p1.equals(p3));  // false

        // Hash consistency
        System.out.println("Same objects, same hash: " +
                (p1.hashCode() == p2.hashCode()));  // true
    }
}
