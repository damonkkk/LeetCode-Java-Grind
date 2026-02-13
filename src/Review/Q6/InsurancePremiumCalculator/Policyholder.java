package Review.Q6.InsurancePremiumCalculator;

public abstract class Policyholder {
    protected int age;
    protected String location;
    protected int claimsCount;
    protected int yearWithCompany;

    public Policyholder(int age, String location, int claimsCount, int yearsWithCompany) {
        this.age = age;
        this.location = location;
        this.claimsCount= claimsCount;
        this.yearWithCompany = yearsWithCompany;
    }

    public abstract double getRiskScore();

    public double getLoyaltyDiscount(){
        double discount = 0.0;

        if (yearWithCompany>=2 && yearWithCompany <=4) {
            discount = 0.05;
        } else if (yearWithCompany>=5 && yearWithCompany <=9) {
            discount = 0.10;
        } else if (yearWithCompany>=10) {
            discount = 0.15;
        }

        return discount;
    }
}
