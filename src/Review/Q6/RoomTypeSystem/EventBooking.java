package Review.Q6.RoomTypeSystem;



public class EventBooking extends Booking{
    private int numberOfRooms;
    public EventBooking(RoomType roomType, Season season,GuestCategory category, int numberOfNights,int numberOfRooms){
        super(roomType,season,category,numberOfNights);
        this.numberOfRooms = numberOfRooms;

    }
    @Override
    public double calculateTotalCost() {
        double discount =0.0;
        if(numberOfRooms >= 10){
            discount=0.25;
        } else if (numberOfRooms>=5 && numberOfRooms <=9) {
            discount = 0.15;
        } else {
            discount = 0.0;
        }

        double perRoomCost = calculateBaseRoomCost() + calculatePackageCost();
        return perRoomCost * numberOfRooms * (1 - discount) * (1 - guestCategory.getLoyaltyDiscount());
    }

    public int getNumberOfRooms(){
        return numberOfRooms;
    }
}
