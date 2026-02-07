package Review.Q6;

public interface ParkingZone {
    double getHourlyRate();
    double calculateFee(int hours, boolean isPeakTime);
}
