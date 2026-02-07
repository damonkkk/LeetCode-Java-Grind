package Review.Q6;

public class Car extends Vehicle{

    public Car(Engine engine){
        super(engine);
    }
    @Override
    public double calculateToll() {
        return engine.getFinalToll()*1.0;
    }
}
