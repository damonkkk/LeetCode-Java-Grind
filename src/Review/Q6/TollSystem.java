package Review.Q6;

import java.util.ArrayList;
import java.util.List;

public class TollSystem {
    public static double calculateTotalRevenue(List<Vehicle> vehicles) {
        double total = 0.0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateToll();
        }
        return total;
    }
    public static void main(String[] args) {
        testBasicEngines();
        testVehicleCalculations();
        testTotalRevenue();
        testMixedVehicles();
    }

    static void testBasicEngines() {
        System.out.println("=== Test Basic Engines ===");
        Engine combustion = new CombustionEngine();
        Engine ev = new EVEngine();
        Engine hybrid = new HybridEngine();

        assert Math.abs(combustion.getFinalToll() - 11.0) < 0.01 : "Combustion toll failed";
        assert Math.abs(ev.getFinalToll() - 8.0) < 0.01 : "EV toll failed";
        assert Math.abs(hybrid.getFinalToll() - 9.5) < 0.01 : "Hybrid toll failed";
        System.out.println("✓ All engine tests passed");
    }

    static void testVehicleCalculations() {
        System.out.println("\n=== Test Vehicle Calculations ===");

        // Car with combustion engine: 10 * 1.1 * 1.0 = 11.0
        Vehicle car = new Car(new CombustionEngine());
        assert Math.abs(car.calculateToll() - 11.0) < 0.01 : "Car toll failed";

        // Truck with EV engine: 10 * 0.8 * 1.5 = 12.0
        Vehicle truck = new Truck(new EVEngine());
        assert Math.abs(truck.calculateToll() - 12.0) < 0.01 : "Truck toll failed";

        // Motorcycle with hybrid: 10 * 0.95 * 0.7 = 6.65
        Vehicle motorcycle = new Motorcycle(new HybridEngine());
        assert Math.abs(motorcycle.calculateToll() - 6.65) < 0.01 : "Motorcycle toll failed";

        // HyperCar with combustion: 10 * 1.1 * 2.0 = 22.0
        Vehicle hyperCar = new HyperCar(new CombustionEngine());
        assert Math.abs(hyperCar.calculateToll() - 22.0) < 0.01 : "HyperCar toll failed";

        System.out.println("✓ All vehicle tests passed");
    }

    static void testTotalRevenue() {
        System.out.println("\n=== Test Total Revenue ===");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(new CombustionEngine())); // 11.0
        vehicles.add(new Truck(new EVEngine())); // 12.0
        vehicles.add(new Motorcycle(new HybridEngine())); // 6.65

        double expected = 11.0 + 12.0 + 6.65;
        double actual = TollSystem.calculateTotalRevenue(vehicles);
        assert Math.abs(actual - expected) < 0.01 : "Total revenue failed";
        System.out.println("✓ Total revenue test passed: $" + actual);
    }

    static void testMixedVehicles() {
        System.out.println("\n=== Test Mixed Vehicles ===");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(new EVEngine())); // 8.0
        vehicles.add(new Car(new HybridEngine())); // 9.5
        vehicles.add(new HyperCar(new CombustionEngine())); // 22.0
        vehicles.add(new Truck(new CombustionEngine())); // 16.5
        vehicles.add(new Motorcycle(new EVEngine())); // 5.6

        double expected = 8.0 + 9.5 + 22.0 + 16.5 + 5.6;
        double actual = TollSystem.calculateTotalRevenue(vehicles);
        assert Math.abs(actual - expected) < 0.01 : "Mixed vehicles failed";
        System.out.println("✓ Mixed vehicles test passed: $" + actual);
    }
}
