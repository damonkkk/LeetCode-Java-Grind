package Review.Q6.InsurancePremiumCalculator;

public class BasicCoverage implements Coverage{
    @Override
    public String getCoverageName() {
        return "Basic";
    }

    @Override
    public double getCoverageLimit() {
        return 50000.0;
    }

    @Override
    public double getDeductible() {
        return 1000.0;
    }

    @Override
    public double getPremiumContribution() {
        return 500.0;
    }
}
