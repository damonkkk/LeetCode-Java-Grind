package Review.Q6.RoomTypeSystem;

public class RegularGuest implements GuestCategory{
    @Override
    public String getCategoryName() {
        return "Regular";
    }

    @Override
    public double getLoyaltyDiscount() {
        return 0.0;
    }

    @Override
    public boolean canAccessExecutiveLounge(){
        return false;
    }
}
