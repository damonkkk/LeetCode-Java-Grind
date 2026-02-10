package Review.Q6.FitnessSystem;

import java.util.List;

public class RevenueAndAnalytics {
    public static double calculateTotalRevenue(List<Member> members, FitnessClass fitnessClass, int hour){
        double total = 0.0;
        for(Member member: members){
            total += member.calculateClassCost(fitnessClass,hour);
        }

        return total;
    }

    public static Member findCheapestMember(List<Member> members, FitnessClass fitnessClass, int hour){
        if(members == null || members.isEmpty()) return null;
        Member cheap = members.get(0);
        for(Member member : members){
            if(member.calculateClassCost(fitnessClass, hour) < cheap.calculateClassCost(fitnessClass, hour)){
                cheap = member;
            }
        }
        return cheap;
    }
}
