package Review.Q6.FitnessSystem;

public class PremiumTier implements MembershipTier{
    @Override
    public double getMonthlyFee() {
        return 60.0;
    }

    @Override
    public int getMonthlyCredits() {
        return 25;
    }

    @Override
    public double getDiscountRate() {
        return 0.85;
    }
}
