package Review.Q6.billingSystem;

public class FamilySubscription extends Subscription{
    public FamilySubscription(ContentTier tier, double regionalMultiplier) {
        super(tier, regionalMultiplier);
    }

    @Override
    public double getDiscountRate() {
        return 0.15;
    }
}
