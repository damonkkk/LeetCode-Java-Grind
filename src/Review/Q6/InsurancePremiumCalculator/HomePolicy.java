package Review.Q6.InsurancePremiumCalculator;

public class HomePolicy implements InsurancePolicy{
    @Override
    public String getPolicyType() {
        return "Home";
    }

    @Override
    public double getBasePremium() {
        return 1200.0;
    }

    @Override
    public double calculateFinalPremium(Policyholder holder, Coverage coverage) {
        return (getBasePremium()+coverage.getPremiumContribution()) * holder.getRiskScore() * (1-holder.getLoyaltyDiscount());
    }
}
