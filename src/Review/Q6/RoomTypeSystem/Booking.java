package Review.Q6.RoomTypeSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Booking {
    protected RoomType room;
    protected Season season;
    protected GuestCategory guestCategory;
    protected int numberOfNights;
    protected List<PackageDeal> packages;



    public Booking(RoomType room, Season season, GuestCategory guestCategory, int numberOfNights){
        this.room=room;
        this.season=season;
        this.guestCategory =guestCategory;
        this.numberOfNights=numberOfNights;
        this.packages = new ArrayList<>();
    }

    public void addPackage(PackageDeal packageDeal){
        if(packageDeal.isApplicableFor(room,numberOfNights)){
            packages.add(packageDeal);
        }
    }


    protected double calculateBaseRoomCost(){
        return room.getBaseNightlyRate()*numberOfNights*season.getMultiplier();

    }
    protected double calculatePackageCost(){
        if(packages.isEmpty()){
            return 0.0;
        }
        double total = 0.0;
        for(PackageDeal pac: packages){
            if(pac instanceof BreakfastPackage){
                total+= pac.getPackageCost() * numberOfNights;
            } else{
                total+= pac.getPackageCost();
            }
        }
        return total;
    }

    public abstract double calculateTotalCost();

    public RoomType getRoom(){
        return room;
    }

    public Season getSeason(){
        return season;
    }
}
