package Review.Q6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class totalRevenue {
    public static double calculateTotalRevenue(List<Vehicle1> vehicles) {
        double total = 0.0;
        for (Vehicle1 vehicle : vehicles) {
            total += vehicle.calculateParkingFee();
        }
        return total;
}


    public static Map<String, Double> getRevenueByZone(List<Vehicle1> vehicles){
        Map<String, Double> map = new HashMap<>();
        for (Vehicle1 vehicle : vehicles) {
            double fee = vehicle.zone.calculateFee(vehicle.parkingDuration, vehicle.isPeakTime);
            map.put(vehicle.toString(),fee);
        }
        return map;

    }


    public static Vehicle1 findMostExpensiveParking(List<Vehicle1> vehicles){
        double max = 0.0;
        int idx = 0;
        String vehicle ;
        for (int i = 0; i<vehicles.size();i++) {
            double fee = vehicles.get(i).calculateParkingFee();
            if(fee > max){
                max = fee;
                idx = i;
            }
        }
        return vehicles.get(idx);
    }


}
