package Review.Q6;

public class ElectricCar extends Car1{
    public ElectricCar(ParkingZone zone, int parkingDuration, boolean isPeakTime) {
        super(zone, parkingDuration, isPeakTime);
    }

    @Override
    public double calculateParkingFee(){
        return zone.calculateFee(parkingDuration,isPeakTime) *getVehicleMultiplier() +2;
    }

    @Override
    public double getVehicleMultiplier(){
        return 0.9;
    }
}
