package Review.Q6.RoomTypeSystem;

public class GoldMember implements GuestCategory{
    @Override
    public String getCategoryName() {
        return "Gold";
    }

    @Override
    public double getLoyaltyDiscount() {
        return 0.10;
    }

    @Override
    public boolean canAccessExecutiveLounge() {
        return true;
    }
}
