package Review.Q6;

public class CombustionEngine implements Engine{



    @Override
    public double getBaseToll() {
        return 10.0;
    }

    @Override
    public double getFinalToll() {
        return getBaseToll() *1.1;
    }
}
