package Review.Q6;

public class HybridEngine implements Engine{
    @Override
    public double getBaseToll() {
        return 10.0;
    }

    @Override
    public double getFinalToll() {
        return 0.95*getBaseToll();
    }
}
