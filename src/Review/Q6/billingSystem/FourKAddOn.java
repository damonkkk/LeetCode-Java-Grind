package Review.Q6.billingSystem;

public class FourKAddOn implements AddOn {
    @Override
    public String getName() {
        return "4K Streaming";
    }

    @Override
    public double getMonthlyCost() {
        return 5.99;
    }

    @Override
    public boolean isCompatibleWith(ContentTier tier) {
        return tier instanceof StandardTier || tier instanceof PremiumTier;
    }
}