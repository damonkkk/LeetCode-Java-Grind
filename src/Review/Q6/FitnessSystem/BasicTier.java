package Review.Q6.FitnessSystem;

public class BasicTier implements MembershipTier{
    @Override
    public double getMonthlyFee() {
        return 30.0;
    }

    @Override
    public int getMonthlyCredits() {
        return 10;
    }

    @Override
    public double getDiscountRate() {
        return 1.0;
    }
}
