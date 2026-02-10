package Review.Q6.RoomTypeSystem;

public class SilverMember implements GuestCategory{
    @Override
    public String getCategoryName() {
        return "Silver";
    }

    @Override
    public double getLoyaltyDiscount() {
        return 0.05;
    }

    @Override
    public boolean canAccessExecutiveLounge() {
        return false;
    }
}
