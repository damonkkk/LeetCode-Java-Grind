package Review.Q6.billingSystem;

import java.util.List;

public class IndividualSubscription extends Subscription{
   public IndividualSubscription(ContentTier tier, double regionalMultiplier){
       super(tier, regionalMultiplier);
   }

    @Override
    public double getDiscountRate() {
        return 0.0;
    }
}
