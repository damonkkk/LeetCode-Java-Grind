package Review.Q6.InsurancePremiumCalculator;



public class IndividualPolicyholder extends Policyholder{
    public IndividualPolicyholder(int age, String location ,int claimsCount, int yearsWithCompany){
        super(age,location,claimsCount,yearsWithCompany);
    }

    @Override
    public double getRiskScore(){
        double score= 1.0;

        if(age<25){
            score+=0.3;
        }
        if(age>65){
            score+=0.2;
        }
        score += claimsCount*0.15;
        if(location.equals("urban")){
            score+= 0.1;
        }
        return score;
    }


}
