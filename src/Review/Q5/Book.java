package Review.Q5;

/**
 * Represents a book in a library system.
 * A book is uniquely identified by its ISBN and year published.
 */
public class Book {
    /**
     * The ISBN code (a positive integer)
     */
    int isbn;

    /**
     * The year the book was published (e.g., 2024)
     */
    int year;

    public Book(int isbn, int year) {
        this.isbn = isbn;
        this.year = year;
    }

    /**
     * @return a hash code value for this object.
     * You may NOT use Object.hashCode() or Objects.hash().
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 *result+isbn;
        result=31*result+year;
        result = Math.abs(result);
        if(result ==0 || result%2 == 0){
            result++;
        }
        return result;
    }

    /**
     * @return true if this book equals the provided object
     */
    @Override
    public boolean equals(Object other) {
        // FIXME: Implement
        // 1. Check if same object (this == other)
        // 2. Check if other is null or different class
        // 3. Cast and compare both fields
        if(this == other){
            return true;
        }
        if(other == null || getClass() != other.getClass()){
            return false;
        }
        Book book = (Book) other;
        return  book.isbn == isbn && book.year == year;



    }

    @Override
    public String toString() {
        return "Book{ISBN=" + isbn + ", year=" + year + "}";
    }

    public static void main(String[] args) {
        Book b1 = new Book(123456, 2020);
        Book b2 = new Book(123456, 2020);
        Book b3 = new Book(123456, 2021);

        // Test equals
        System.out.println("b1.equals(b2): " + b1.equals(b2));  // true
        System.out.println("b1.equals(b3): " + b1.equals(b3));  // false

        // Test hash consistency
        System.out.println("b1.hashCode() == b2.hashCode(): " +
                (b1.hashCode() == b2.hashCode()));  // true

        // Different books should (likely) have different hashes
        System.out.println("b1 hash: " + b1.hashCode());
        System.out.println("b3 hash: " + b3.hashCode());
    }
}