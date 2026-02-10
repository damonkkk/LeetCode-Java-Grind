package Review.Q6.FitnessSystem;

public class LifetimeTier implements MembershipTier{
    @Override
    public double getMonthlyFee() {
        return 0.00;
    }

    @Override
    public int getMonthlyCredits() {
        return 999;
    }

    @Override
    public double getDiscountRate() {
        return 0.5;
    }
}
