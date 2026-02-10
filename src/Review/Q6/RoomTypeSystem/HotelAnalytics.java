package Review.Q6.RoomTypeSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelAnalytics {
    public static double calculateTotalRevenue(List<Booking> bookings){
        if(bookings.isEmpty()){
            return 0.0;
        }
        double total = 0.0;
        for(Booking booking: bookings){
            total+= booking.calculateTotalCost();
        }
        return total;
    }


    public static Map<Season, Double> getRevenueBySeason(List<Booking> bookings){
        HashMap<Season,Double> map = new HashMap<>();
        for(Booking booking:bookings){
            Season season = booking.getSeason();
            double rev = booking.calculateTotalCost();
            map.put(season,map.getOrDefault(season,0.0)+rev);
        }

        return map;
    }


    public static Map<String, Integer> getRoomTypeDistribution(List<Booking> bookings){
        HashMap<String, Integer> map = new HashMap<>();
        for(Booking booking:bookings) {
            String roomType = booking.getRoom().getClass().getSimpleName();
            if (booking instanceof EventBooking) {
                int numbs = ((EventBooking) booking).getNumberOfRooms();
                map.put(roomType, map.getOrDefault(roomType, 0) + numbs);
            } else {
                map.put(roomType, map.getOrDefault(roomType, 0) + 1);
            }
        }
        return map;
    }


    public static double getAverageBookingValue(List<Booking> bookings){
        if (bookings.isEmpty()) return 0.0;
        return calculateTotalRevenue(bookings)/ bookings.size();
    }

    static Booking findHighestValueBooking(List<Booking> bookings){
//        double max = 0.0;
//        for(Booking booking: bookings){
//            if(booking.calculateTotalCost()>= max){
//                max = booking.calculateTotalCost();
//            }
//        }
//        return bookings.get(bookings.indexOf(max));
//    }

        Booking max = bookings.get(0);
        for(Booking booking:bookings){
        if(booking.calculateTotalCost() > max.calculateTotalCost()){
            max = booking;
        }

        }
        return max;
    }
}
