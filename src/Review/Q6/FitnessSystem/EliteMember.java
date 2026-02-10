package Review.Q6.FitnessSystem;

public class EliteMember extends Member{
    public EliteMember(MembershipTier tier, boolean isFamilyPlan, boolean isCorporate) {
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
}
