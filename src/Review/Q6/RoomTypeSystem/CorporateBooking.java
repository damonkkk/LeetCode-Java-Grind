package Review.Q6.RoomTypeSystem;

public class CorporateBooking extends Booking{
    public CorporateBooking(RoomType room, Season season, GuestCategory guestCategory,int numberOfNights){
        super(room,season, guestCategory, numberOfNights);
    }

    @Override
    public double calculateTotalCost() {
        double roomCost=  calculateBaseRoomCost() * 0.8;
        return (roomCost+calculatePackageCost())*(1-guestCategory.getLoyaltyDiscount());
    }
}
