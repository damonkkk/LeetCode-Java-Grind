package Review.Q6.InsurancePremiumCalculator;

public class StandardCoverage implements Coverage{
    @Override
    public String getCoverageName() {
        return "Standard";
    }

    @Override
    public double getCoverageLimit() {
        return 150000.0;
    }

    @Override
    public double getDeductible() {
        return 500.0;
    }

    @Override
    public double getPremiumContribution() {
        return 1200.0;
    }
}
