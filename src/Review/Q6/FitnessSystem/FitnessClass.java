package Review.Q6.FitnessSystem;

public interface FitnessClass {
    String getClassName();
    int getCreditsRequired();
    double getDropInPrice();
    double getPeakMultiplier();
     static boolean isPeakTime(int hour){
        if(hour>= 6 && hour<=9){
            return true;
        }
        if(hour>=17 && hour<=20){
            return true;
        }
        return false;
    };
}
