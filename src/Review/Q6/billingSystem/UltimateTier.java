package Review.Q6.billingSystem;

import java.util.List;

public class UltimateTier implements ContentTier{
    @Override
    public double getMonthlyBaseFee() {
        return 24.99;
    }

    @Override
    public int getMaxSimultaneousStreams() {
        return 6;
    }

    @Override
    public List<String> getIncludedFeatures() {
        return List.of("4K Ultra HD", "Six Devices", "HDR+", "Dolby Atmos");
    }
}
