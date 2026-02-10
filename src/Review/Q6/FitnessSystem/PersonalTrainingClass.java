package Review.Q6.FitnessSystem;

public class PersonalTrainingClass implements FitnessClass{
    @Override
    public String getClassName() {
        return "PersonalTrainingClass";
    }

    @Override
    public int getCreditsRequired() {
        return 8;
    }

    @Override
    public double getDropInPrice() {
        return 50.0;
    }

    @Override
    public double getPeakMultiplier() {
        return 1.6;
    }
}
