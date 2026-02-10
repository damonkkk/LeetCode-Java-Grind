package Review.Q6.RoomTypeSystem;

import java.util.List;

public class DeluxeRoom implements RoomType{
    @Override
    public double getBaseNightlyRate(){
        return 250.0;
    }

    @Override
    public int getCapacity(){
        return 3;
    }

    @Override
    public List<String> getAmenities(){
        return List.of("WiFi", "Smart TV", "Premium Mini Bar", "City View");
    }
}
