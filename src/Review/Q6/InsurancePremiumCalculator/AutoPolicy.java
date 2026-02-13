package Review.Q6.InsurancePremiumCalculator;

public class AutoPolicy implements InsurancePolicy{
    @Override
    public String getPolicyType() {
        return "Auto";
    }

    @Override
    public double getBasePremium() {
        return 800.0;
    }

    @Override
    public double calculateFinalPremium(Policyholder holder, Coverage coverage) {
        return (getBasePremium()+coverage.getPremiumContribution()) * holder.getRiskScore() * (1-holder.getLoyaltyDiscount());
    }
}
