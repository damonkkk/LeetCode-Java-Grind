package Review.Q6;

public class ElectricCar extends Car1{
    public ElectricCar(ParkingZone zone, int parkingDuration, boolean isPeakTime) {
        super(zone, parkingDuration, isPeakTime);
    }

    @Override
    public double calculateParkingFee(){
        return zone.calculateFee(parkingDuration,isPeakTime);
    }

    @Override
    public double getVehicleMultiplier(){
        return calculateParkingFee() * 0.9+2;
    }
}
