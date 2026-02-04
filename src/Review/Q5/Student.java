package Review.Q5;

import java.util.Random;

/**
 * This class represents a Student in a university enrollment system.
 * A student is uniquely identified by their studentID, name, and major.
 */
public class Student {
    /**
     * The unique student ID (a positive integer)
     */
    int studentID;

    /**
     * The student's full name (a string of ASCII characters)
     */
    String name;

    /**
     * The student's major field of study (a string of ASCII characters)
     */
    String major;

    public Student(int studentID, String name, String major) {
        this.studentID = studentID;
        this.name = name;
        this.major = major;
    }

    /**
     * @return a hash code value for this object.
     * In implementing this method, you may *not* use the default Java
     * implementations in Object.hashCode() or Objects.hash().
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 7;
        result = 13*result+studentID;
        result = 13*result+name.hashCode();
        result= 13 *result+major.hashCode();
        return result;
    }

    /**
     * @return a secondary hash code value for use in double hashing collision resolution.
     * This hash code MUST be different from the primary hashCode() method.
     * CRITICAL: This method must NEVER return 0 (to avoid infinite loops in probing).
     * CRITICAL: The return value should be odd (to ensure it's coprime with even table sizes).
     * In implementing this method, you may *not* use the default Java
     * implementations in Object.hashCode() or Objects.hash().
     */
    public int secondaryHashCode() {
        int result = 17;
        result = 31 *result+studentID;
        result=31*result+name.hashCode();
        result =31*result+major.hashCode();
        result = Math.abs(result);
        if(result ==0 || result%2 == 0){
            result++;
        }
        return result;
    }

    /**
     * @return true if this student is equal to the provided object
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {


        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student S = (Student) object;
        return studentID == S.studentID &&
                name.equals(S.name) &&
                major.equals(S.major);

    }

    @Override
    public String toString() {
        return "Student{ID=" + studentID + ", name='" + name + "', major='" + major + "'}";
    }
}