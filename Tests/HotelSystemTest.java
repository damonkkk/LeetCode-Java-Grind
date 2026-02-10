import Review.Q6.*;
import Review.Q6.RoomTypeSystem.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HotelSystemTest {
    public static void main(String[] args) {
        testRoomTypes();
        testSeasons();
        testGuestCategories();
        testPackages();
        testBookingTypes();
        testAnalytics();
        testComplexScenarios();
    }

    static void testRoomTypes() {
        System.out.println("=== Test Room Types ===");

        RoomType standard = new StandardRoom();
        assert Math.abs(standard.getBaseNightlyRate() - 150.0) < 0.01;
        assert standard.getCapacity() == 2;

        RoomType suite = new SuiteRoom();
        assert Math.abs(suite.getBaseNightlyRate() - 450.0) < 0.01;
        assert suite.getAmenities().contains("Jacuzzi");

        System.out.println("✓ Room type tests passed");
    }

    static void testSeasons() {
        System.out.println("\n=== Test Seasons ===");

        assert Math.abs(Season.PEAK.getMultiplier() - 1.5) < 0.01;
        assert Math.abs(Season.OFF_SEASON.getMultiplier() - 0.7) < 0.01;

        System.out.println("✓ Season tests passed");
    }

    static void testGuestCategories() {
        System.out.println("\n=== Test Guest Categories ===");

        GuestCategory regular = new RegularGuest();
        assert Math.abs(regular.getLoyaltyDiscount() - 0.0) < 0.01;
        assert !regular.canAccessExecutiveLounge();

        GuestCategory platinum = new PlatinumMember();
        assert Math.abs(platinum.getLoyaltyDiscount() - 0.15) < 0.01;
        assert platinum.canAccessExecutiveLounge();

        System.out.println("✓ Guest category tests passed");
    }

    static void testPackages() {
        System.out.println("\n=== Test Packages ===");

        PackageDeal breakfast = new BreakfastPackage();
        PackageDeal spa = new SpaPackage();
        PackageDeal romantic = new RomanticGetaway();

        RoomType standard = new StandardRoom();
        RoomType deluxe = new DeluxeRoom();

        assert breakfast.isApplicableFor(standard, 1);
        assert !spa.isApplicableFor(standard, 1);
        assert spa.isApplicableFor(deluxe, 1);
        assert !romantic.isApplicableFor(deluxe, 1); // Needs 2+ nights
        assert romantic.isApplicableFor(deluxe, 2);

        System.out.println("✓ Package tests passed");
    }

    static void testBookingTypes() {
        System.out.println("\n=== Test Booking Types ===");

        RoomType deluxe = new DeluxeRoom();

        // Standard booking: 250 * 3 * 1.0 = 750, with 10% gold discount = 675
        Booking standard = new StandardBooking(deluxe, Season.SHOULDER, new GoldMember(), 3);
        double standardCost = standard.calculateTotalCost();
        assert Math.abs(standardCost - 675.0) < 0.01;

        // Corporate booking: (250 * 3 * 1.0 * 0.8) * 0.9 = 540
        Booking corporate = new CorporateBooking(deluxe, Season.SHOULDER, new GoldMember(), 3);
        double corporateCost = corporate.calculateTotalCost();
        assert Math.abs(corporateCost - 540.0) < 0.01;

        System.out.println("✓ Booking type tests passed");
    }

    static void testAnalytics() {
        System.out.println("\n=== Test Analytics ===");

        List<Booking> bookings = new ArrayList<>();

        bookings.add(new StandardBooking(new StandardRoom(), Season.PEAK, new RegularGuest(), 2));
        bookings.add(new StandardBooking(new DeluxeRoom(), Season.SHOULDER, new GoldMember(), 3));
        bookings.add(new CorporateBooking(new SuiteRoom(), Season.OFF_SEASON, new PlatinumMember(), 5));

        double totalRevenue = HotelAnalytics.calculateTotalRevenue(bookings);
        System.out.println("Total revenue: $" + totalRevenue);
        assert totalRevenue > 0;

        Map<Season, Double> revenueBySeason = HotelAnalytics.getRevenueBySeason(bookings);
        System.out.println("Revenue by season: " + revenueBySeason);

        Map<String, Integer> roomDist = HotelAnalytics.getRoomTypeDistribution(bookings);
        System.out.println("Room distribution: " + roomDist);

        double avgValue = HotelAnalytics.getAverageBookingValue(bookings);
        System.out.println("Average booking value: $" + avgValue);

        System.out.println("✓ Analytics tests passed");
    }

    static void testComplexScenarios() {
        System.out.println("\n=== Test Complex Scenarios ===");

        // Event booking with packages
        EventBooking event = new EventBooking(new DeluxeRoom(), Season.PEAK,
                new PlatinumMember(), 3, 8);
        event.addPackage(new BreakfastPackage());

        double eventCost = event.calculateTotalCost();
        System.out.println("Event booking cost: $" + eventCost);
        // Base: 250 * 3 * 1.5 = 1125 per room
        // Breakfast: 25 * 3 = 75 per room
        // Total per room: 1200
        // 8 rooms: 9600
        // 15% volume discount: 9600 * 0.85 = 8160
        // 15% platinum discount: 8160 * 0.85 = 6936
        assert Math.abs(eventCost - 6936.0) < 0.5;

        System.out.println("✓ Complex scenario tests passed");
    }
}