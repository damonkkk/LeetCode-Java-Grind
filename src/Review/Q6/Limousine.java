package Review.Q6;

public class Limousine extends Car1{
    public Limousine(ParkingZone zone, int parkingDuration, boolean isPeakTime) {
        super(zone, parkingDuration, isPeakTime);
    }

    @Override
    public double calculateParkingFee(){
        return zone.calculateFee(parkingDuration,isPeakTime);
    }

    @Override
    public double getVehicleMultiplier(){
        return calculateParkingFee() * 2.0;
    }
}
