package Review.Q6;

public class EVEngine implements Engine{
    @Override
    public double getBaseToll() {
        return 10.0;
    }

    @Override
    public double getFinalToll() {
        return 0.8*getBaseToll();
    }
}
