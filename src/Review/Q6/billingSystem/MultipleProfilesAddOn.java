package Review.Q6.billingSystem;

public class MultipleProfilesAddOn implements AddOn{
    @Override
    public String getName() {
        return "Multiple Profiles";
    }

    @Override
    public double getMonthlyCost() {
        return 2.99;
    }

    @Override
    public boolean isCompatibleWith(ContentTier tier) {
        return true;
    }
}
