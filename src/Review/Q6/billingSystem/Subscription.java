package Review.Q6.billingSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscription {
    protected ContentTier tier;
    protected List<AddOn> addOns;
    protected double regionalMultiplier;

    public Subscription(ContentTier tier, double regionalMultiplier){
        this.tier =tier;
        this.regionalMultiplier = regionalMultiplier;
        //List<AddOn> addOns= new ArrayList<>();
        this.addOns = new ArrayList<>();
    }

    public void addAddOn(AddOn addOn){
        if(addOn.isCompatibleWith(tier)){
           addOns.add(addOn);
        }
    }

    public abstract double getDiscountRate();

    public double calculateMonthlyFee(){
        double total = 0.0;
        double costAddon = 0.0;
        double discount = 1-getDiscountRate();

        for(var a: addOns){
            costAddon+= a.getMonthlyCost();
        }
        total = (tier.getMonthlyBaseFee() + costAddon)*discount;

        return total*regionalMultiplier;
    }

    public ContentTier getTier(){
        return tier;
    }

}
