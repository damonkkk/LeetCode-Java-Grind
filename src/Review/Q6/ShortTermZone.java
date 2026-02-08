package Review.Q6;

public class ShortTermZone implements ParkingZone{
    @Override
    public double getHourlyRate() {
        return 5.0;
    }

    @Override
    public double calculateFee(int hours, boolean isPeakTime) {
        double fee = 0.0;
        if(hours<=24){
            if(isPeakTime){
                fee =  getHourlyRate() * 1.3*hours;
            } else{
                fee=  getHourlyRate() *0.9*hours;
            }
        }
        return fee;
    }
}
