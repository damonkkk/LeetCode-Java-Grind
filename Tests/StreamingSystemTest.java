import Review.Q6.billingSystem.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamingSystemTest {
    public static void main(String[] args) {
        testTiers();
        testAddOns();
        testSubscriptionTypes();
        testRevenueCalculations();
        testAnalytics();
    }

    static void testTiers() {
        System.out.println("=== Test Tiers ===");

        ContentTier basic = new BasicTier();
        assert Math.abs(basic.getMonthlyBaseFee() - 9.99) < 0.01;
        assert basic.getMaxSimultaneousStreams() == 1;

        ContentTier ultimate = new UltimateTier();
        assert Math.abs(ultimate.getMonthlyBaseFee() - 24.99) < 0.01;
        assert ultimate.getMaxSimultaneousStreams() == 6;

        System.out.println("✓ Tier tests passed");
    }

    static void testAddOns() {
        System.out.println("\n=== Test Add-Ons ===");

        AddOn fourK = new FourKAddOn();
        ContentTier basic = new BasicTier();
        ContentTier standard = new StandardTier();
        ContentTier ultimate = new UltimateTier();

        assert !fourK.isCompatibleWith(basic);
        assert fourK.isCompatibleWith(standard);
        assert !fourK.isCompatibleWith(ultimate); // Ultimate includes 4K

        System.out.println("✓ Add-on compatibility tests passed");
    }

    static void testSubscriptionTypes() {
        System.out.println("\n=== Test Subscription Types ===");

        ContentTier premium = new PremiumTier();

        // Individual: 19.99 * 1.0 * 1.0 = 19.99
        Subscription individual = new IndividualSubscription(premium, 1.0);
        assert Math.abs(individual.calculateMonthlyFee() - 19.99) < 0.01;

        // Student: 19.99 * 0.75 * 1.0 = 14.99
        Subscription student = new StudentSubscription(premium, 1.0);
        assert Math.abs(student.calculateMonthlyFee() - 14.9925) < 0.01;

        // Family with regional multiplier: 19.99 * 0.85 * 1.2 = 20.39
        Subscription family = new FamilySubscription(premium, 1.2);
        assert Math.abs(family.calculateMonthlyFee() - 20.3898) < 0.01;

        System.out.println("✓ Subscription type tests passed");
    }

    static void testRevenueCalculations() {
        System.out.println("\n=== Test Revenue Calculations ===");

        List<Subscription> subs = new ArrayList<>();

        Subscription sub1 = new IndividualSubscription(new BasicTier(), 1.0);
        Subscription sub2 = new FamilySubscription(new PremiumTier(), 1.0);
        Subscription sub3 = new StudentSubscription(new StandardTier(), 1.0);

        subs.add(sub1);
        subs.add(sub2);
        subs.add(sub3);

        double total = StreamingAnalytics.calculateTotalMonthlyRevenue(subs);
        System.out.println("Total monthly revenue: $" + total);
        assert total > 0;

        System.out.println("✓ Revenue calculation tests passed");
    }

    static void testAnalytics() {
        System.out.println("\n=== Test Analytics ===");

        List<Subscription> subs = new ArrayList<>();
        subs.add(new IndividualSubscription(new BasicTier(), 1.0));
        subs.add(new IndividualSubscription(new StandardTier(), 1.0));
        subs.add(new FamilySubscription(new PremiumTier(), 1.0));
        subs.add(new StudentSubscription(new BasicTier(), 1.0));

        Map<String, Integer> distribution = StreamingAnalytics.getSubscriptionDistribution(subs);
        System.out.println("Subscription distribution: " + distribution);
        assert distribution.get("IndividualSubscription") == 2;

        Map<String, Double> revenueByTier = StreamingAnalytics.getRevenueByTier(subs);
        System.out.println("Revenue by tier: " + revenueByTier);

        double avgRevenue = StreamingAnalytics.getAverageRevenuePerUser(subs);
        System.out.println("Average revenue per user: $" + avgRevenue);

        System.out.println("✓ Analytics tests passed");
    }
}