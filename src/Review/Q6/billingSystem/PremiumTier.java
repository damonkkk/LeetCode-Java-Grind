package Review.Q6.billingSystem;

import java.util.List;

public class PremiumTier implements ContentTier{
    @Override
    public double getMonthlyBaseFee() {
        return 19.99;
    }

    @Override
    public int getMaxSimultaneousStreams() {
        return 4;
    }

    @Override
    public List<String> getIncludedFeatures() {
        return List.of("Full HD Quality", "Four Devices", "HDR");
    }
}
