package Review.Q6.FitnessSystem;

public class YogaClass implements FitnessClass{
    @Override
    public String getClassName() {
        return "YogaClass";
    }

    @Override
    public int getCreditsRequired() {
        return 2;
    }

    @Override
    public double getDropInPrice() {
        return 15.0;
    }

    @Override
    public double getPeakMultiplier() {
        return 1.3;
    }


}
