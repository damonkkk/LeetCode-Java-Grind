package Review.Q6.InsurancePremiumCalculator;

public class FamilyPolicyholder extends IndividualPolicyholder{
    private int dependentCount;
    public FamilyPolicyholder(int age, String location ,int claimsCount, int yearsWithCompany,int dependentCount){
        super(age,location,claimsCount,yearsWithCompany);
        this.dependentCount = dependentCount;

    }

    @Override
    public double getRiskScore() {
        return super.getRiskScore() + (0.05 * dependentCount);
    }
}
