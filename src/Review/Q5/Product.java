package Review.Q5;

/**
 * This class represents a Product in an inventory management system.
 * A product is uniquely identified by its productID, name, and category.
 */
public class Product {
    /**
     * The unique product ID (a positive integer)
     */
    int productID;

    /**
     * The product name (a string of ASCII characters)
     */
    String name;

    /**
     * The product category (a string of ASCII characters)
     */
    String category;

    public Product(int productID, String name, String category) {
        this.productID = productID;
        this.name = name;
        this.category = category;
    }

    /**
     * @return a hash code value for this object.
     * In implementing this method, you may NOT use the default Java
     * implementations in Object.hashCode() or Objects.hash().
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + name.hashCode();
        result = 31*result+category.hashCode();
        return result;
    }

    /**
     * @return a secondary hash code value for use in double hashing.
     * This hash code MUST be different from the primary hashCode() method.
     * CRITICAL: This method must NEVER return 0 (to avoid infinite loops in probing).
     * CRITICAL: The return value should ideally be odd (to ensure it's coprime with even table sizes).
     */
    public int secondaryHashCode() {
        int result = 7;
       result =37*result+productID;
       result=37*result +category.hashCode();
       result=37*result+name.hashCode();
       if(result==0 || result %2 ==0){
           result++;
       }
       return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Product product = (Product) other;
        return productID == product.productID &&
                name.equals(product.name) &&
                category.equals(product.category);
    }
}