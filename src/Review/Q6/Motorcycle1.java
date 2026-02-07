package Review.Q6;

public abstract class Motorcycle1 extends Vehicle1{

    public Motorcycle1(ParkingZone zone, int parkingDuration,boolean isPeakTime){
        super(zone,parkingDuration,isPeakTime);

    }

    @Override
    public double calculateParkingFee(){
        return zone.calculateFee(parkingDuration,isPeakTime);
    }

    @Override
    public double getVehicleMultiplier(){
        return calculateParkingFee() * 0.5;
    }
}
