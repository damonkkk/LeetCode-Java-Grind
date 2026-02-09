package Review.Q6.billingSystem;

import java.util.List;

public interface ContentTier {
    double getMonthlyBaseFee();
    int getMaxSimultaneousStreams();
    List<String> getIncludedFeatures();
}
