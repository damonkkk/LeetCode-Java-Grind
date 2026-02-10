package Review.Q6.RoomTypeSystem;

public interface PackageDeal {
    String getPackageName();
    double getPackageCost();
    boolean isApplicableFor(RoomType room, int nights);
}
