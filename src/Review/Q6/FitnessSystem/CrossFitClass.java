package Review.Q6.FitnessSystem;

public class CrossFitClass implements FitnessClass{
    @Override
    public String getClassName() {
        return "CrossFitClass";
    }

    @Override
    public int getCreditsRequired() {
        return 4;
    }

    @Override
    public double getDropInPrice() {
        return 25.0;
    }

    @Override
    public double getPeakMultiplier() {
        return 1.4;
    }
}
