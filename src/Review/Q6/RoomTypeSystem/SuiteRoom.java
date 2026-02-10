package Review.Q6.RoomTypeSystem;

import java.util.List;

public class SuiteRoom implements RoomType{
    @Override
    public double getBaseNightlyRate(){
        return 450.0;
    }

    @Override
    public int getCapacity(){
        return 4;
    }

    @Override
    public List<String> getAmenities(){
        return List.of("WiFi", "Smart TV", "Full Kitchen", "Balcony", "Jacuzzi", "Ocean View", "Butler Service");
    }
}
