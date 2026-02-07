package Review.Q6;

public class Motorcycle extends  Vehicle{
    public Motorcycle(Engine engine) {
        super(engine);
    }
    @Override
    public double calculateToll() {
        return engine.getFinalToll() * 0.7;
    }
}
