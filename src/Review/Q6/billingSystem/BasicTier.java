package Review.Q6.billingSystem;

import java.util.List;

public class BasicTier implements ContentTier{
    @Override
    public double getMonthlyBaseFee() {
        return 9.99;
    }

    @Override
    public int getMaxSimultaneousStreams() {
        return 1;
    }

    @Override
    public List<String> getIncludedFeatures() {
        return List.of("SD Quality", "Single Device");
    }
}
