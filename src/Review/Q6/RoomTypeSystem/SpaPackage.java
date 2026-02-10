package Review.Q6.RoomTypeSystem;

public class SpaPackage implements PackageDeal{
    @Override
    public String getPackageName() {
        return "Spa & Wellness";
    }

    @Override
    public double getPackageCost() {
        return 150.0;
    }

    @Override
    public boolean isApplicableFor(RoomType room, int nights) {
      return room instanceof DeluxeRoom || room instanceof SuiteRoom;
    }
}
