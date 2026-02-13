package Review.Q6.InsurancePremiumCalculator;

public interface InsurancePolicy {
    String getPolicyType();
    double getBasePremium();
double calculateFinalPremium(Policyholder holder, Coverage coverage);
}
