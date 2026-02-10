package Review.Q6.RoomTypeSystem;

public class RomanticGetaway implements PackageDeal{
    @Override
    public String getPackageName() {
        return "Romantic Getaway";
    }

    @Override
    public double getPackageCost() {
        return 200.0;
    }

    @Override
    public boolean isApplicableFor(RoomType room, int nights) {
        if(nights>=2){
            return room instanceof DeluxeRoom || room instanceof SuiteRoom;
        }
       return false;
    }
}
