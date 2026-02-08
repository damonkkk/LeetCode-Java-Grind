package Review.Q6;

public class Car1 extends Vehicle1{
    public Car1(ParkingZone zone, int parkingDuration,boolean isPeakTime) {
        super(zone,parkingDuration,isPeakTime);
    }


    @Override
    public double calculateParkingFee() {
        return zone.calculateFee(parkingDuration,isPeakTime) * getVehicleMultiplier();
    }

    @Override
    public double getVehicleMultiplier() {
        return  1.0;
    }
}
