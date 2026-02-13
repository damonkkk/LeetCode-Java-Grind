package Review.Q6.InsurancePremiumCalculator;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class InsurancePremiumCalculatorTest {

    // ─────────────────────────────────────────────────────────────────────────
    // PART A: Coverage Tests
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    public void testBasicCoverageFields() {
        Coverage c = new BasicCoverage();
        assertEquals("Basic", c.getCoverageName());
        assertEquals(50000.0,  c.getCoverageLimit(),   0.001);
        assertEquals(1000.0,   c.getDeductible(),      0.001);
        assertEquals(500.0,    c.getPremiumContribution(), 0.001);
    }

    @Test
    public void testStandardCoverageFields() {
        Coverage c = new StandardCoverage();
        assertEquals("Standard", c.getCoverageName());
        assertEquals(150000.0, c.getCoverageLimit(),   0.001);
        assertEquals(500.0,    c.getDeductible(),      0.001);
        assertEquals(1200.0,   c.getPremiumContribution(), 0.001);
    }

    @Test
    public void testComprehensiveCoverageFields() {
        Coverage c = new ComprehensiveCoverage();
        assertEquals("Comprehensive", c.getCoverageName());
        assertEquals(500000.0, c.getCoverageLimit(),   0.001);
        assertEquals(250.0,    c.getDeductible(),      0.001);
        assertEquals(2500.0,   c.getPremiumContribution(), 0.001);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // PART B: Policyholder.getLoyaltyDiscount() Tests
    // ─────────────────────────────────────────────────────────────────────────

    // Using IndividualPolicyholder as a concrete Policyholder to test getLoyaltyDiscount()

    @Test
    public void testLoyaltyDiscount_lessThan2Years() {
        // 0 years → no discount
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 0);
        assertEquals(0.0, p.getLoyaltyDiscount(), 0.001);
    }

    @Test
    public void testLoyaltyDiscount_1Year() {
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 1);
        assertEquals(0.0, p.getLoyaltyDiscount(), 0.001);
    }

    @Test
    public void testLoyaltyDiscount_exactly2Years() {
        // Boundary: 2 years → 5%
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 2);
        assertEquals(0.05, p.getLoyaltyDiscount(), 0.001);
    }

    @Test
    public void testLoyaltyDiscount_4Years() {
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 4);
        assertEquals(0.05, p.getLoyaltyDiscount(), 0.001);
    }

    @Test
    public void testLoyaltyDiscount_exactly5Years() {
        // Boundary: 5 years → 10%
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 5);
        assertEquals(0.10, p.getLoyaltyDiscount(), 0.001);
    }

    @Test
    public void testLoyaltyDiscount_9Years() {
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 9);
        assertEquals(0.10, p.getLoyaltyDiscount(), 0.001);
    }

    @Test
    public void testLoyaltyDiscount_exactly10Years() {
        // Boundary: 10 years → 15%
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 10);
        assertEquals(0.15, p.getLoyaltyDiscount(), 0.001);
    }

    @Test
    public void testLoyaltyDiscount_20Years() {
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 20);
        assertEquals(0.15, p.getLoyaltyDiscount(), 0.001);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // PART B: IndividualPolicyholder.getRiskScore() Tests
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    public void testIndividual_baseRisk_noModifiers() {
        // Age 30, rural, 0 claims → 1.0
        Policyholder p = new IndividualPolicyholder(30, "rural", 0, 0);
        assertEquals(1.0, p.getRiskScore(), 0.001);
    }

    @Test
    public void testIndividual_youngDriver() {
        // Age 22 (< 25), rural, 0 claims → 1.0 + 0.30 = 1.30
        Policyholder p = new IndividualPolicyholder(22, "rural", 0, 0);
        assertEquals(1.30, p.getRiskScore(), 0.001);
    }

    @Test
    public void testIndividual_seniorDriver() {
        // Age 70 (> 65), rural, 0 claims → 1.0 + 0.20 = 1.20
        Policyholder p = new IndividualPolicyholder(70, "rural", 0, 0);
        assertEquals(1.20, p.getRiskScore(), 0.001);
    }

    @Test
    public void testIndividual_urbanLocation() {
        // Age 30, urban, 0 claims → 1.0 + 0.10 = 1.10
        Policyholder p = new IndividualPolicyholder(30, "urban", 0, 0);
        assertEquals(1.10, p.getRiskScore(), 0.001);
    }

    @Test
    public void testIndividual_withClaims() {
        // Age 30, rural, 2 claims → 1.0 + 0.30 = 1.30
        Policyholder p = new IndividualPolicyholder(30, "rural", 2, 0);
        assertEquals(1.30, p.getRiskScore(), 0.001);
    }

    @Test
    public void testIndividual_allModifiers() {
        // Age 22, urban, 1 claim → 1.0 + 0.30 + 0.10 + 0.15 = 1.55
        Policyholder p = new IndividualPolicyholder(22, "urban", 1, 0);
        assertEquals(1.55, p.getRiskScore(), 0.001);
    }

    @Test
    public void testIndividual_exactlyAge25_noYoungPenalty() {
        // Boundary: age exactly 25, not < 25 → base 1.0 only
        Policyholder p = new IndividualPolicyholder(25, "rural", 0, 0);
        assertEquals(1.0, p.getRiskScore(), 0.001);
    }

    @Test
    public void testIndividual_exactlyAge65_noSeniorPenalty() {
        // Boundary: age exactly 65, not > 65 → base 1.0 only
        Policyholder p = new IndividualPolicyholder(65, "rural", 0, 0);
        assertEquals(1.0, p.getRiskScore(), 0.001);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // PART B: FamilyPolicyholder.getRiskScore() Tests
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    public void testFamily_noDependents() {
        // Same as individual: age 30, rural, 0 claims, 0 dependents → 1.0
        Policyholder p = new FamilyPolicyholder(30, "rural", 0, 0, 0);
        assertEquals(1.0, p.getRiskScore(), 0.001);
    }

    @Test
    public void testFamily_withDependents() {
        // Age 30, rural, 0 claims, 3 dependents → 1.0 + (0.05 × 3) = 1.15
        Policyholder p = new FamilyPolicyholder(30, "rural", 0, 0, 3);
        assertEquals(1.15, p.getRiskScore(), 0.001);
    }

    @Test
    public void testFamily_allModifiersIncludingDependents() {
        // Age 22, urban, 1 claim, 2 dependents → 1.55 + (0.05 × 2) = 1.65
        Policyholder p = new FamilyPolicyholder(22, "urban", 1, 0, 2);
        assertEquals(1.65, p.getRiskScore(), 0.001);
    }

    @Test
    public void testFamily_extendsIndividual() {
        // FamilyPolicyholder should be an instance of IndividualPolicyholder
        FamilyPolicyholder fp = new FamilyPolicyholder(30, "rural", 0, 0, 1);
        assertInstanceOf(IndividualPolicyholder.class, fp);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // PART B: BusinessPolicyholder.getRiskScore() Tests
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    public void testBusiness_retail() {
        Policyholder p = new BusinessPolicyholder(40, "urban", 5, 0, "retail");
        assertEquals(1.2, p.getRiskScore(), 0.001);
    }

    @Test
    public void testBusiness_construction() {
        Policyholder p = new BusinessPolicyholder(40, "urban", 5, 0, "construction");
        assertEquals(1.8, p.getRiskScore(), 0.001);
    }

    @Test
    public void testBusiness_tech() {
        Policyholder p = new BusinessPolicyholder(40, "urban", 5, 0, "tech");
        assertEquals(1.0, p.getRiskScore(), 0.001);
    }

    @Test
    public void testBusiness_ignoresAgeAndClaims() {
        // Even a young person with many claims should still get industry score only
        Policyholder p = new BusinessPolicyholder(20, "urban", 10, 0, "tech");
        assertEquals(1.0, p.getRiskScore(), 0.001);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // PART C: Policy calculateFinalPremium() Tests
    // ─────────────────────────────────────────────────────────────────────────

    // Example from the problem statement:
    // IndividualPolicyholder: age 30, urban, 1 claim, 6 years
    // StandardCoverage, AutoPolicy
    // Risk: 1.0 + 0.10 + 0.15 = 1.25
    // Loyalty: 0.10 (5-9 years)
    // Final: (800 + 1200) × 1.25 × 0.90 = 2250.0

    @Test
    public void testAutoPolicy_exampleFromSpec() {
        Policyholder holder   = new IndividualPolicyholder(30, "urban", 1, 6);
        Coverage coverage     = new StandardCoverage();
        InsurancePolicy policy = new AutoPolicy();
        assertEquals(2250.0, policy.calculateFinalPremium(holder, coverage), 0.01);
    }

    @Test
    public void testAutoPolicy_getPolicyType() {
        assertEquals("Auto", new AutoPolicy().getPolicyType());
    }

    @Test
    public void testAutoPolicy_getBasePremium() {
        assertEquals(800.0, new AutoPolicy().getBasePremium(), 0.001);
    }

    @Test
    public void testAutoPolicy_noDiscount_noRiskModifier() {
        // Age 30, rural, 0 claims, 0 years → risk 1.0, discount 0.0
        // (800 + 500) × 1.0 × 1.0 = 1300.0
        Policyholder holder   = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage     = new BasicCoverage();
        InsurancePolicy policy = new AutoPolicy();
        assertEquals(1300.0, policy.calculateFinalPremium(holder, coverage), 0.01);
    }

    @Test
    public void testHomePolicy_getPolicyType() {
        assertEquals("Home", new HomePolicy().getPolicyType());
    }

    @Test
    public void testHomePolicy_getBasePremium() {
        assertEquals(1200.0, new HomePolicy().getBasePremium(), 0.001);
    }

    @Test
    public void testHomePolicy_basicCalculation() {
        // Age 30, rural, 0 claims, 0 years → risk 1.0, discount 0.0
        // (1200 + 500) × 1.0 × 1.0 = 1700.0
        Policyholder holder   = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage     = new BasicCoverage();
        InsurancePolicy policy = new HomePolicy();
        assertEquals(1700.0, policy.calculateFinalPremium(holder, coverage), 0.01);
    }

    @Test
    public void testLifePolicy_getPolicyType() {
        assertEquals("Life", new LifePolicy().getPolicyType());
    }

    @Test
    public void testLifePolicy_getBasePremium() {
        assertEquals(600.0, new LifePolicy().getBasePremium(), 0.001);
    }

    @Test
    public void testLifePolicy_basicCalculation() {
        // Age 30, rural, 0 claims, 0 years → risk 1.0 (under cap), discount 0.0
        // (600 + 500) × 1.0 × 1.0 = 1100.0
        Policyholder holder   = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage     = new BasicCoverage();
        InsurancePolicy policy = new LifePolicy();
        assertEquals(1100.0, policy.calculateFinalPremium(holder, coverage), 0.01);
    }

    @Test
    public void testLifePolicy_riskCapAt2() {
        // Very high risk: age 22, urban, 5 claims
        // Raw risk = 1.0 + 0.30 + 0.10 + (5 × 0.15) = 2.15 → capped at 2.0
        // (600 + 500) × 2.0 × 1.0 = 2200.0
        Policyholder holder   = new IndividualPolicyholder(22, "urban", 5, 0);
        Coverage coverage     = new BasicCoverage();
        InsurancePolicy policy = new LifePolicy();
        assertEquals(2200.0, policy.calculateFinalPremium(holder, coverage), 0.01);
    }

    @Test
    public void testLifePolicy_riskBelowCap_noChange() {
        // Risk = 1.25 which is below cap of 2.0 → cap has no effect
        // (600 + 1200) × 1.25 × 0.90 = 2025.0
        Policyholder holder   = new IndividualPolicyholder(30, "urban", 1, 6);
        Coverage coverage     = new StandardCoverage();
        InsurancePolicy policy = new LifePolicy();
        assertEquals(2025.0, policy.calculateFinalPremium(holder, coverage), 0.01);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // PART D: PolicyPortfolio Tests
    // ─────────────────────────────────────────────────────────────────────────

    @Test
    public void testPortfolioValue_singlePolicy() {
        Policyholder holder = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage   = new BasicCoverage();
        List<InsurancePolicy> policies = List.of(new AutoPolicy());
        // (800 + 500) × 1.0 × 1.0 = 1300.0
        assertEquals(1300.0, PolicyPortfolio.calculatePortfolioValue(policies, holder, coverage), 0.01);
    }

    @Test
    public void testPortfolioValue_multiplePolicies() {
        Policyholder holder = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage   = new BasicCoverage();
        List<InsurancePolicy> policies = List.of(new AutoPolicy(), new HomePolicy());
        // Auto: 1300.0 + Home: 1700.0 = 3000.0
        assertEquals(3000.0, PolicyPortfolio.calculatePortfolioValue(policies, holder, coverage), 0.01);
    }

    @Test
    public void testBundledPremium_onePolicy_noDiscount() {
        Policyholder holder = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage   = new BasicCoverage();
        List<InsurancePolicy> policies = List.of(new AutoPolicy());
        // 1 policy → no discount → 1300.0
        assertEquals(1300.0, PolicyPortfolio.calculateBundledPremium(policies, holder, coverage), 0.01);
    }

    @Test
    public void testBundledPremium_twoPolicies_5percentOff() {
        Policyholder holder = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage   = new BasicCoverage();
        List<InsurancePolicy> policies = List.of(new AutoPolicy(), new HomePolicy());
        // 3000.0 × 0.95 = 2850.0
        assertEquals(2850.0, PolicyPortfolio.calculateBundledPremium(policies, holder, coverage), 0.01);
    }

    @Test
    public void testBundledPremium_threePolicies_10percentOff() {
        Policyholder holder = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage   = new BasicCoverage();
        List<InsurancePolicy> policies = List.of(new AutoPolicy(), new HomePolicy(), new LifePolicy());
        // Auto: 1300 + Home: 1700 + Life: 1100 = 4100 × 0.90 = 3690.0
        assertEquals(3690.0, PolicyPortfolio.calculateBundledPremium(policies, holder, coverage), 0.01);
    }

    @Test
    public void testBundledPremium_fourPolicies_10percentOff() {
        // 4+ policies should also get 10% off (>= 3 check)
        Policyholder holder = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage   = new BasicCoverage();
        List<InsurancePolicy> policies = List.of(
                new AutoPolicy(), new HomePolicy(), new LifePolicy(), new AutoPolicy()
        );
        // 1300 + 1700 + 1100 + 1300 = 5400 × 0.90 = 4860.0
        assertEquals(4860.0, PolicyPortfolio.calculateBundledPremium(policies, holder, coverage), 0.01);
    }

    @Test
    public void testBundledPremium_emptyList_returnsZero() {
        Policyholder holder = new IndividualPolicyholder(30, "rural", 0, 0);
        Coverage coverage   = new BasicCoverage();
        List<InsurancePolicy> policies = List.of();
        assertEquals(0.0, PolicyPortfolio.calculateBundledPremium(policies, holder, coverage), 0.01);
    }
}