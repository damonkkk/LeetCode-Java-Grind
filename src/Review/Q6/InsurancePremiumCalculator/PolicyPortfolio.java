package Review.Q6.InsurancePremiumCalculator;

import java.util.List;

public class PolicyPortfolio {

    public static double calculatePortfolioValue(
            List<InsurancePolicy> policies,
            Policyholder holder,
            Coverage coverage
    ){
        double total = 0.0;

        for (InsurancePolicy policy: policies){
            total+= policy.calculateFinalPremium(holder,coverage);
        }

        return total;

    }



    public static double calculateBundledPremium(
            List<InsurancePolicy> policies,
            Policyholder holder,
            Coverage coverage
    ){
        double total = calculatePortfolioValue(policies, holder, coverage);
        if (policies.size() == 2) return total * 0.95;
        if (policies.size() >= 3) return total * 0.90;
        return total;  // size == 1, no discount

    }
}
