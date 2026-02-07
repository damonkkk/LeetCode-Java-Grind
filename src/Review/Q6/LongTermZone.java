package Review.Q6;

public class LongTermZone implements ParkingZone{
    @Override
    public double getHourlyRate() {
        return 3.0;
    }

    @Override
    public double calculateFee(int hours, boolean isPeakTime) {
        double fee = 0.0;
        if(hours<=24){
            if(isPeakTime){
                fee =  getHourlyRate() * 1.3* hours;
            } else{
                fee=  getHourlyRate() *0.9 *hours;
            }
            return fee;
        }

        if(hours>24){
            double discountHour = hours-24;
            if(isPeakTime){
                fee =  getHourlyRate() * 1.3* hours;
            }else{
                fee=  getHourlyRate() *0.9 *hours;
            }
            fee=  fee + 0.9 * discountHour;
        }
        return fee;
    }
}
