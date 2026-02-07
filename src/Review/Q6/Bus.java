package Review.Q6;

public abstract class Bus extends Vehicle1{

    public Bus(ParkingZone zone, int parkingDuration,boolean isPeakTime){
        super(zone,parkingDuration,isPeakTime);

    }

    @Override
    public double calculateParkingFee(){
        return zone.calculateFee(parkingDuration,isPeakTime);
    }

    @Override
    public double getVehicleMultiplier(){
        return calculateParkingFee() * 2.5;
    }
}