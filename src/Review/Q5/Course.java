package Review.Q5;

/**
 * Represents a university course.
 */
public class Course {
    String courseCode;    // e.g., "COMP1110"
    String courseName;    // e.g., "Structured Programming"
    int credits;          // e.g., 6
    String instructor;    // e.g., "Dr. Smith"

    public Course(String courseCode, String courseName, int credits, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
    }

    /**
     * Primary hash code.
     * You may NOT use Object.hashCode() or Objects.hash().
     */
    @Override
    public int hashCode() {
        int r = 17;
        r = 31*r +credits;
        r= 31*r+courseCode.hashCode();
        r=31*r+courseName.hashCode();
        r=31*r+instructor.hashCode();
        return r;
    }

    /**
     * Secondary hash code for double hashing.
     * Must be different, non-zero, and odd.
     */
    public int secondaryHashCode() {
        int r = 7;
        r = 17*r +credits;
        r= 17*r+courseCode.hashCode();
        r=17*r+courseName.hashCode();
        r=17*r+instructor.hashCode();
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
      if(other==null||getClass() != other.getClass()){
          return false;
      }
      Course course = (Course) other;
       return course.credits ==credits &&
               courseCode.equals(course.courseCode) &&
               courseName.equals(course.courseName) &&
               instructor.equals(course.instructor);
    }
}
