package Review.Q6.RoomTypeSystem;

public class BreakfastPackage implements PackageDeal{
    @Override
    public String getPackageName() {
        return "Breakfast Included";
    }

    @Override
    public double getPackageCost() {
        return 25.0;
    }

    @Override
    public boolean isApplicableFor(RoomType room, int nights) {
        return true;
    }
}
