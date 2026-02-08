package Review.Q6;

public class LongTermZone implements ParkingZone{
    @Override
    public double getHourlyRate() {
        return 3.0;
    }

    @Override
    public double calculateFee(int hours, boolean isPeakTime) {
        double fee = 0.0;
        if(hours<=24) {
            double multiplier = isPeakTime ? 1.3 : 0.9;
            fee = getHourlyRate() * hours * multiplier;
        }else{
            // First 24 hours with peak/off-peak
            double multiplier = isPeakTime ? 1.3 : 0.9;
            fee = getHourlyRate() * 24 * multiplier;
            // Hours beyond 24 get 0.9 discount (no peak/off-peak)
            int extraHours = hours - 24;
            fee += getHourlyRate() * extraHours * 0.9;
        }
        return fee;
    }
}
