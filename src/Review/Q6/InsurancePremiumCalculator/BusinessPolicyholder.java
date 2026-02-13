package Review.Q6.InsurancePremiumCalculator;

public class BusinessPolicyholder extends Policyholder{
    private String industryType;
    public BusinessPolicyholder(int age, String location ,int claimsCount, int yearsWithCompany,String industryType){
        super(age,location,claimsCount,yearsWithCompany);
        this.industryType=industryType;
    }

    @Override
    public double getRiskScore() {
        double score= 0.0;
        if(industryType.equals("retail")){
            score= 1.2;
        } else if (industryType.equals("construction")) {
            score = 1.8;
        }else if (industryType.equals("tech")){
           score =1.0;
        }
        return score;
    }
}
