package Review.Q6;

abstract class Vehicle1 {
    protected ParkingZone zone;
    protected  int parkingDuration;
    protected boolean isPeakTime;

    public Vehicle1(ParkingZone zone, int parkingDuration,boolean isPeakTime){
        this.zone =zone;
        this.isPeakTime =isPeakTime;
        this.parkingDuration = parkingDuration;
    }

    public abstract double calculateParkingFee();
    public abstract double  getVehicleMultiplier();

}
