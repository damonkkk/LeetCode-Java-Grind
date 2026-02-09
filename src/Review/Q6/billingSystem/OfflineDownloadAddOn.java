package Review.Q6.billingSystem;

public class OfflineDownloadAddOn implements AddOn{
    @Override
    public String getName() {
        return "Offline Downloads";
    }

    @Override
    public double getMonthlyCost() {
        return 3.99;
    }

    @Override
    public boolean isCompatibleWith(ContentTier tier) {
        return !(tier instanceof BasicTier);
    }
}
