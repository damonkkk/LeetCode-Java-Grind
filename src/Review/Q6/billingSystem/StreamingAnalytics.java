package Review.Q6.billingSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamingAnalytics {

    //Returns the sum of monthly fees from all subscriptions
    public static double calculateTotalMonthlyRevenue(List<Subscription> subscriptions){

        double total = 0.0;
        // loop through all subs in subscription and call method to find their monthly fee then sum them up
        for(var subs: subscriptions){
            total+= subs.calculateMonthlyFee();
        }

        return total;
    }


    // Returns a map where keys are subscription type names (e.g., "IndividualSubscription") and values are the count of each type
    public static Map<String, Integer> getSubscriptionDistribution(List<Subscription> subscriptions){
        //new map to store
        HashMap<String,Integer> map = new HashMap<>();

        // since return requires the subscription name, so use getClass().getSimpleName() as the key. do we have better way to do it ?
        // use getOrDefault, get the current count for that subs, if it has no count, then default value will be 0, we now encountered one ,so we add one
        // if it is not zero, we still add one since we're now currently encountering one
        for(var subs: subscriptions){
            String name = subs.getClass().getSimpleName();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        return map;
    }


    //Returns a map where keys are tier names (e.g., "BasicTier") and values are the total revenue from that tier
    public static Map<String, Double> getRevenueByTier(List<Subscription> subscriptions){
        //new map to store
        HashMap<String, Double> map = new HashMap<>();

        // since return requires the subscription name, so use getClass().getSimpleName() as the key. do we have better way to do it ?
        // use getOrDefault, get the current revenue for that subs, if it has no revenue, then default value will be 0, we now encountered revenue ,so we add revenue
        // if it is not zero, we still add revenue since we're now currently encountering revenue
        for(var subs: subscriptions){
            String name = subs.tier.getClass().getSimpleName();
            double rev = subs.calculateMonthlyFee();

            map.put(name,  (map.getOrDefault(name, 0.0) + rev));
        }
        return map;
    }


    //Returns the average monthly fee across all subscriptions
    //Return 0.0 if the list is empty
    public static double getAverageRevenuePerUser(List<Subscription> subscriptions){
        if(subscriptions.isEmpty()){
            return 0.0;
        }
        // total/ size = average
        return  calculateTotalMonthlyRevenue(subscriptions)/ subscriptions.size();
    }
}
