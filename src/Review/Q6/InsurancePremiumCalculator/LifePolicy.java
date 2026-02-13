package Review.Q6.InsurancePremiumCalculator;

public class LifePolicy implements InsurancePolicy{
    @Override
    public String getPolicyType() {
        return "Life";
    }

    @Override
    public double getBasePremium() {
        return 600.0;
    }

    @Override
    public double calculateFinalPremium(Policyholder holder, Coverage coverage) {
        return (getBasePremium()+coverage.getPremiumContribution()) * Math.min(holder.getRiskScore(), 2.0) * (1-holder.getLoyaltyDiscount());
    }
}