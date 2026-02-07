package Review.Q6;

public class Truck extends Vehicle{
    public Truck(Engine engine) {
        super(engine);
    }
    @Override
    public double calculateToll() {
        return engine.getFinalToll() * 1.5;
    }
}
