import Review.Q6.FitnessSystem.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test file for Fitness Membership System
 * Tests all parts: Tiers, Classes, Members, and Revenue/Analytics
 *
 * Expected output assumes all bugs from review are FIXED:
 *   - Member field init moved to constructor
 *   - bookClass uses creditsRemaining (not tier credits)
 *   - LifetimeMember.bookClass deducts from creditsRemaining
 *   - BasicMember/PremiumMember check isPeakTime before applying multiplier
 *   - findCheapestMember semicolon + null check fixed
 */
public class FitnessSystemTest {

    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  FITNESS MEMBERSHIP SYSTEM TESTS");
        System.out.println("========================================\n");

        testPartA_Tiers();
        testPartB_FitnessClasses();
        testPartC_Members();
        testPartD_RevenueAndAnalytics();

        System.out.println("\n========================================");
        System.out.printf("  RESULTS: %d passed, %d failed, %d total%n", passed, failed, passed + failed);
        System.out.println("========================================");
    }

    // ===== PART A: Membership Tiers =====
    static void testPartA_Tiers() {
        System.out.println("--- Part A: Membership Tiers ---");

        MembershipTier basic = new BasicTier();
        check("BasicTier monthlyFee", basic.getMonthlyFee(), 30.0);
        check("BasicTier monthlyCredits", basic.getMonthlyCredits(), 10);
        check("BasicTier discountRate", basic.getDiscountRate(), 1.0);

        MembershipTier premium = new PremiumTier();
        check("PremiumTier monthlyFee", premium.getMonthlyFee(), 60.0);
        check("PremiumTier monthlyCredits", premium.getMonthlyCredits(), 25);
        check("PremiumTier discountRate", premium.getDiscountRate(), 0.85);

        MembershipTier elite = new EliteTier();
        check("EliteTier monthlyFee", elite.getMonthlyFee(), 100.0);
        check("EliteTier monthlyCredits", elite.getMonthlyCredits(), 50);
        check("EliteTier discountRate", elite.getDiscountRate(), 0.7);

        MembershipTier lifetime = new LifetimeTier();
        check("LifetimeTier monthlyFee", lifetime.getMonthlyFee(), 0.0);
        check("LifetimeTier monthlyCredits", lifetime.getMonthlyCredits(), 999);
        check("LifetimeTier discountRate", lifetime.getDiscountRate(), 0.5);

        System.out.println();
    }

    // ===== PART B: Fitness Classes =====
    static void testPartB_FitnessClasses() {
        System.out.println("--- Part B: Fitness Classes ---");

        // Test isPeakTime
        check("isPeakTime(6) = true",  FitnessClass.isPeakTime(6), true);
        check("isPeakTime(9) = true",  FitnessClass.isPeakTime(9), true);
        check("isPeakTime(10) = false", FitnessClass.isPeakTime(10), false);
        check("isPeakTime(16) = false", FitnessClass.isPeakTime(16), false);
        check("isPeakTime(17) = true", FitnessClass.isPeakTime(17), true);
        check("isPeakTime(20) = true", FitnessClass.isPeakTime(20), true);
        check("isPeakTime(21) = false", FitnessClass.isPeakTime(21), false);
        check("isPeakTime(3) = false",  FitnessClass.isPeakTime(3), false);

        // Yoga
        FitnessClass yoga = new YogaClass();
        check("Yoga name", yoga.getClassName(), "YogaClass");
        check("Yoga credits", yoga.getCreditsRequired(), 2);
        check("Yoga dropIn", yoga.getDropInPrice(), 15.0);
        check("Yoga peakMult", yoga.getPeakMultiplier(), 1.3);

        // Spin
        FitnessClass spin = new SpinClass();
        check("Spin credits", spin.getCreditsRequired(), 3);
        check("Spin dropIn", spin.getDropInPrice(), 20.0);
        check("Spin peakMult", spin.getPeakMultiplier(), 1.5);

        // CrossFit
        FitnessClass crossfit = new CrossFitClass();
        check("CrossFit credits", crossfit.getCreditsRequired(), 4);
        check("CrossFit dropIn", crossfit.getDropInPrice(), 25.0);
        check("CrossFit peakMult", crossfit.getPeakMultiplier(), 1.4);

        // Swimming
        FitnessClass swim = new SwimmingClass();
        check("Swimming credits", swim.getCreditsRequired(), 2);
        check("Swimming dropIn", swim.getDropInPrice(), 12.0);
        check("Swimming peakMult", swim.getPeakMultiplier(), 1.2);

        // PersonalTraining
        FitnessClass pt = new PersonalTrainingClass();
        check("PT credits", pt.getCreditsRequired(), 8);
        check("PT dropIn", pt.getDropInPrice(), 50.0);
        check("PT peakMult", pt.getPeakMultiplier(), 1.6);

        System.out.println();
    }

    // ===== PART C: Members =====
    static void testPartC_Members() {
        System.out.println("--- Part C: Member Cost Calculations ---");

        FitnessClass yoga = new YogaClass();       // dropIn=15, peak=1.3
        FitnessClass spin = new SpinClass();        // dropIn=20, peak=1.5
        FitnessClass pt = new PersonalTrainingClass(); // dropIn=50, peak=1.6

        // ----- BasicMember (no family, no corporate) -----
        // Off-peak (hour=12): 15 * 1.0 * 1.0 = 15.0
        Member basicOff = new BasicMember(new BasicTier(), false, false);
        check("Basic yoga off-peak", basicOff.calculateClassCost(yoga, 12), 15.0);

        // Peak (hour=8): 15 * 1.3 * 1.0 = 19.5
        Member basicPeak = new BasicMember(new BasicTier(), false, false);
        check("Basic yoga peak", basicPeak.calculateClassCost(yoga, 8), 19.5);

        // ----- BasicMember with family plan -----
        // Peak (hour=7): 15 * 1.3 * 1.0 * 0.9 = 17.55
        Member basicFamily = new BasicMember(new BasicTier(), true, false);
        check("Basic yoga peak+family", basicFamily.calculateClassCost(yoga, 7), 17.55);

        // ----- BasicMember with corporate -----
        // Off-peak (hour=14): 15 * 1.0 * 1.0 * 0.8 = 12.0
        Member basicCorp = new BasicMember(new BasicTier(), false, true);
        check("Basic yoga off-peak+corp", basicCorp.calculateClassCost(yoga, 14), 12.0);

        // ----- BasicMember with BOTH family + corporate -----
        // Peak (hour=18): 15 * 1.3 * 1.0 * 0.9 * 0.8 = 14.04
        Member basicBoth = new BasicMember(new BasicTier(), true, true);
        check("Basic yoga peak+family+corp", basicBoth.calculateClassCost(yoga, 18), 14.04);

        // ----- PremiumMember -----
        // Off-peak (hour=12): 20 * 1.0 * 0.85 = 17.0
        Member premOff = new PremiumMember(new PremiumTier(), false, false);
        check("Premium spin off-peak", premOff.calculateClassCost(spin, 12), 17.0);

        // Peak (hour=6): 20 * 1.5 * 0.85 = 25.5
        Member premPeak = new PremiumMember(new PremiumTier(), false, false);
        check("Premium spin peak", premPeak.calculateClassCost(spin, 6), 25.5);

        // ----- EliteMember (NO peak pricing) -----
        // Hour=8 (peak, but elite ignores): 50 * 1.0 * 0.7 = 35.0
        Member elitePeak = new EliteMember(new EliteTier(), false, false);
        check("Elite PT peak(ignored)", elitePeak.calculateClassCost(pt, 8), 35.0);

        // Hour=14 (off-peak): 50 * 1.0 * 0.7 = 35.0 (same!)
        check("Elite PT off-peak", elitePeak.calculateClassCost(pt, 14), 35.0);

        // Elite with family: 50 * 1.0 * 0.7 * 0.9 = 31.5
        Member eliteFamily = new EliteMember(new EliteTier(), true, false);
        check("Elite PT family", eliteFamily.calculateClassCost(pt, 8), 31.5);

        // ----- LifetimeMember (NO peak pricing) -----
        // Hour=18 (peak, but lifetime ignores): 15 * 1.0 * 0.5 = 7.5
        Member lifePeak = new LifetimeMember(new LifetimeTier(), false, false);
        check("Lifetime yoga peak(ignored)", lifePeak.calculateClassCost(yoga, 18), 7.5);

        // Lifetime with family+corp: 15 * 1.0 * 0.5 * 0.9 * 0.8 = 5.4
        Member lifeBoth = new LifetimeMember(new LifetimeTier(), true, true);
        check("Lifetime yoga family+corp", lifeBoth.calculateClassCost(yoga, 18), 5.4);

        System.out.println();

        // ----- Booking Tests -----
        System.out.println("--- Part C: Booking System ---");

        // BasicMember has 10 credits, yoga needs 2
        Member bookBasic = new BasicMember(new BasicTier(), false, false);
        check("Basic book yoga (10 credits)", bookBasic.bookClass(yoga, 12), true);
        // After booking: 10 - 2 = 8 credits remaining
        check("Basic book yoga again (8 credits)", bookBasic.bookClass(yoga, 12), true);
        // After: 6 credits. Book PT (needs 8) — should fail
        check("Basic book PT (6 credits, need 8)", bookBasic.bookClass(pt, 12), false);

        // BasicMember: book until credits run out
        Member bookBasic2 = new BasicMember(new BasicTier(), false, false);
        // 10 credits, spin needs 3: book 3 times = 9 credits used, 1 left
        check("book spin 1 (10 cr)", bookBasic2.bookClass(spin, 12), true);
        check("book spin 2 (7 cr)", bookBasic2.bookClass(spin, 12), true);
        check("book spin 3 (4 cr)", bookBasic2.bookClass(spin, 12), true);
        // 1 credit left, spin needs 3 — fail
        check("book spin 4 (1 cr) FAIL", bookBasic2.bookClass(spin, 12), false);

        // LifetimeMember: booking always succeeds, credits can go negative
        Member bookLife = new LifetimeMember(new LifetimeTier(), false, false);
        // 999 credits, PT needs 8
        check("Lifetime book PT", bookLife.bookClass(pt, 12), true);
        // Book many times — should never fail
        for (int i = 0; i < 130; i++) {
            bookLife.bookClass(pt, 12); // 130 * 8 = 1040 credits deducted
        }
        // After: 999 - 8 - 1040 = -49, but should still succeed
        check("Lifetime book PT (negative credits)", bookLife.bookClass(pt, 12), true);

        System.out.println();
    }

    // ===== PART D: Revenue and Analytics =====
    static void testPartD_RevenueAndAnalytics() {
        System.out.println("--- Part D: Revenue & Analytics ---");

        FitnessClass yoga = new YogaClass();
        FitnessClass spin = new SpinClass();
        int peakHour = 8;
        int offPeakHour = 12;

        // calculateTotalRevenue
        List<Member> members = new ArrayList<>();
        members.add(new BasicMember(new BasicTier(), false, false));
        members.add(new PremiumMember(new PremiumTier(), false, false));
        members.add(new EliteMember(new EliteTier(), false, false));
        members.add(new LifetimeMember(new LifetimeTier(), false, false));

        // Yoga off-peak:
        //   Basic:    15 * 1.0 * 1.0 = 15.0
        //   Premium:  15 * 1.0 * 0.85 = 12.75
        //   Elite:    15 * 1.0 * 0.7 = 10.5
        //   Lifetime: 15 * 1.0 * 0.5 = 7.5
        //   Total = 45.75
        check("totalRevenue yoga off-peak",
                RevenueAndAnalytics.calculateTotalRevenue(members, yoga, offPeakHour), 45.75);

        // Yoga peak:
        //   Basic:    15 * 1.3 * 1.0 = 19.5
        //   Premium:  15 * 1.3 * 0.85 = 16.575
        //   Elite:    15 * 1.0 * 0.7 = 10.5  (no peak)
        //   Lifetime: 15 * 1.0 * 0.5 = 7.5   (no peak)
        //   Total = 54.075
        check("totalRevenue yoga peak",
                RevenueAndAnalytics.calculateTotalRevenue(members, yoga, peakHour), 54.075);

        // findCheapestMember — Lifetime should be cheapest (7.5)
        Member cheapest = RevenueAndAnalytics.findCheapestMember(members, yoga, offPeakHour);
        check("cheapest member is LifetimeMember",
                cheapest instanceof LifetimeMember, true);

        // findCheapestMember with empty list
        List<Member> emptyList = new ArrayList<>();
        check("cheapest with empty list = null",
                RevenueAndAnalytics.findCheapestMember(emptyList, yoga, 12) == null, true);

        // findCheapestMember — all same tier
        List<Member> sameTier = new ArrayList<>();
        sameTier.add(new BasicMember(new BasicTier(), false, false));   // 15.0
        sameTier.add(new BasicMember(new BasicTier(), true, false));    // 13.5
        sameTier.add(new BasicMember(new BasicTier(), true, true));     // 10.8
        Member cheapSame = RevenueAndAnalytics.findCheapestMember(sameTier, yoga, offPeakHour);
        // The family+corp member (10.8) should be cheapest
        double cheapCost = cheapSame.calculateClassCost(yoga, offPeakHour);
        check("cheapest among basics is family+corp (10.8)", cheapCost, 10.8);

        System.out.println();
    }

    // ===== Helper methods =====
    static void check(String testName, double actual, double expected) {
        if (Math.abs(actual - expected) < 0.001) {
            System.out.printf("  ✅ PASS: %s (%.4f)%n", testName, actual);
            passed++;
        } else {
            System.out.printf("  ❌ FAIL: %s — expected %.4f, got %.4f%n", testName, expected, actual);
            failed++;
        }
    }

    static void check(String testName, int actual, int expected) {
        if (actual == expected) {
            System.out.printf("  ✅ PASS: %s (%d)%n", testName, actual);
            passed++;
        } else {
            System.out.printf("  ❌ FAIL: %s — expected %d, got %d%n", testName, expected, actual);
            failed++;
        }
    }

    static void check(String testName, boolean actual, boolean expected) {
        if (actual == expected) {
            System.out.printf("  ✅ PASS: %s (%b)%n", testName, actual);
            passed++;
        } else {
            System.out.printf("  ❌ FAIL: %s — expected %b, got %b%n", testName, expected, actual);
            failed++;
        }
    }

    static void check(String testName, String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.printf("  ✅ PASS: %s (\"%s\")%n", testName, actual);
            passed++;
        } else {
            System.out.printf("  ❌ FAIL: %s — expected \"%s\", got \"%s\"%n", testName, expected, actual);
            failed++;
        }
    }
}