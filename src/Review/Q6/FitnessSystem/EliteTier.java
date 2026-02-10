package Review.Q6.FitnessSystem;

public class EliteTier implements MembershipTier{
    @Override
    public double getMonthlyFee() {
        return 100.0;
    }

    @Override
    public int getMonthlyCredits() {
        return 50;
    }

    @Override
    public double getDiscountRate() {
        return 0.7;
    }
}
