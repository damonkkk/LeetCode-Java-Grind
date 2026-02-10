package Review.Q6.RoomTypeSystem;

public class StandardBooking extends Booking {
    public StandardBooking(RoomType room, Season season, GuestCategory guestCategory, int numberOfNights) {
        super(room, season, guestCategory, numberOfNights);
    }

    @Override
    public double calculateTotalCost() {
        double roomCost = calculateBaseRoomCost();
        return (roomCost + calculatePackageCost()) * (1 - guestCategory.getLoyaltyDiscount());
    }
}
