package Review.Q6.billingSystem;

import java.util.List;

public class StandardTier implements ContentTier{
    @Override
    public double getMonthlyBaseFee() {
        return 14.99;
    }

    @Override
    public int getMaxSimultaneousStreams() {
        return 2;
    }

    @Override
    public List<String> getIncludedFeatures() {
        return List.of("HD Quality", "Two Devices");
    }
}
