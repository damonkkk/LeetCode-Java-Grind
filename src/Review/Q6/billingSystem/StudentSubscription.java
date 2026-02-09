package Review.Q6.billingSystem;

public class StudentSubscription extends Subscription{
    public StudentSubscription(ContentTier tier, double regionalMultiplier){
        super(tier, regionalMultiplier);
    }

    @Override
    public double getDiscountRate(){
        return 0.25;
    }
}
