package Review.Q6.RoomTypeSystem;

import java.util.List;

public class StandardRoom implements RoomType{
    @Override
    public double getBaseNightlyRate(){
        return 150.0;
    }

    @Override
    public int getCapacity() {
        return 2;
    }

    @Override
    public List<String> getAmenities(){
        return List.of("WiFi", "TV", "Mini Bar");
    }
}
