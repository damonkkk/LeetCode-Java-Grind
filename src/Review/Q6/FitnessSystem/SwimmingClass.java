package Review.Q6.FitnessSystem;

public class SwimmingClass implements FitnessClass{
    @Override
    public String getClassName() {
        return "SwimmingClass";
    }

    @Override
    public int getCreditsRequired() {
        return 2;
    }

    @Override
    public double getDropInPrice() {
        return 12.0;
    }

    @Override
    public double getPeakMultiplier() {
        return 1.2;
    }
}
