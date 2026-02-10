package Review.Q6.FitnessSystem;

public class SpinClass implements FitnessClass{
    @Override
    public String getClassName() {
        return "SpinClass";
    }

    @Override
    public int getCreditsRequired() {
        return 3;
    }

    @Override
    public double getDropInPrice() {
        return 20.0;
    }

    @Override
    public double getPeakMultiplier() {
        return 1.5;
    }
}
