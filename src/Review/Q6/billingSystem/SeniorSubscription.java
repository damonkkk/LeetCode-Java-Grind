package Review.Q6.billingSystem;

public class SeniorSubscription extends Subscription{
    public SeniorSubscription(ContentTier tier, double regionalMultiplier){
        super(tier,regionalMultiplier);
    }

    @Override
    public double getDiscountRate(){
        return 0.2;
    }


}
