package Review.Q6.FitnessSystem;

public class PremiumMember extends Member{
    public PremiumMember(MembershipTier tier, boolean isFamilyPlan, boolean isCorporate) {
        super(tier, isFamilyPlan, isCorporate);
    }

    @Override
    public double calculateClassCost(FitnessClass fitnessClass, int hour) {
        double peakMult = FitnessClass.isPeakTime(hour) ? fitnessClass.getPeakMultiplier() : 1.0;
        double base =  fitnessClass.getDropInPrice() * peakMult* tier.getDiscountRate();
        if(isFamilyPlan){
            base *=0.9;
        }
        if (isCorporate){
            base *= 0.8;
        }
        return base;
    }
}
