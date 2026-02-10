package Review.Q6.RoomTypeSystem;

public enum Season {
    PEAK(1.5),
    SHOULDER(1.0),
    OFF_SEASON(0.7);

    private final double multiplier;


    Season(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

}
