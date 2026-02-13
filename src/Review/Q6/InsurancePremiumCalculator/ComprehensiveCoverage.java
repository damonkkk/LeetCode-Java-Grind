package Review.Q6.InsurancePremiumCalculator;

public class ComprehensiveCoverage implements Coverage{
    @Override
    public String getCoverageName() {
        return "Comprehensive";
    }

    @Override
    public double getCoverageLimit() {
        return 500000.0;
    }

    @Override
    public double getDeductible() {
        return 250.0;
    }

    @Override
    public double getPremiumContribution() {
        return 2500.0;
    }
}
