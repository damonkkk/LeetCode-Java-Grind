package Review.Q6.billingSystem;

public interface AddOn {
    String getName();
    double getMonthlyCost();
    boolean isCompatibleWith(ContentTier tier);
}
