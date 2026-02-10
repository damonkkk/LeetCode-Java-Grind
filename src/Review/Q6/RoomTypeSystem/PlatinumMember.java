package Review.Q6.RoomTypeSystem;

public class PlatinumMember implements GuestCategory{
    @Override
    public String getCategoryName() {
        return "Platinum";
    }

    @Override
    public double getLoyaltyDiscount() {
        return 0.15;
    }

    @Override
    public boolean canAccessExecutiveLounge() {
        return true;
    }
}
