package Review.Q6.RoomTypeSystem;

import java.util.List;

public interface RoomType {
    double getBaseNightlyRate();
    int getCapacity();
    List<String> getAmenities();
}
