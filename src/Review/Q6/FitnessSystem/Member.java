package Review.Q6.FitnessSystem;

public abstract class Member {
    protected MembershipTier tier;
    protected int creditsRemaining;
    protected boolean isFamilyPlan = false;
    protected boolean isCorporate =false;

    public Member(MembershipTier tier, boolean isFamilyPlan, boolean isCorporate){
        this.tier =tier;
        this.creditsRemaining = tier.getMonthlyCredits();
        this.isFamilyPlan =isFamilyPlan;
        this.isCorporate = isCorporate;
    }

    public abstract double calculateClassCost(FitnessClass fitnessClass, int hour);

    public boolean bookClass(FitnessClass fitnessClass, int hour){
        if(creditsRemaining >= fitnessClass.getCreditsRequired()){
            creditsRemaining -= fitnessClass.getCreditsRequired();
            return true;
        }
        return false;
    }

}
