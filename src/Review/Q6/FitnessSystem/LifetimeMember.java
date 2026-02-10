package Review.Q6.FitnessSystem;

public class LifetimeMember extends Member{
    public LifetimeMember(MembershipTier tier, boolean isFamilyPlan, boolean isCorporate) {
        super(tier, isFamilyPlan, isCorporate);
    }

    @Override
    public double calculateClassCost(FitnessClass fitnessClass, int hour) {
        double base =  fitnessClass.getDropInPrice() * tier.getDiscountRate();
        if(isFamilyPlan){
            base *=0.9;
        }
        if (isCorporate){
            base *= 0.8;
        }
        return base;
    }
    @Override
    public boolean bookClass(FitnessClass fitnessClass, int hour){
            creditsRemaining -= fitnessClass.getCreditsRequired();
            return true;
    }
}
