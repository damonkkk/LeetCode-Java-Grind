package Review.Q6;

class HyperCar extends Car {
    public HyperCar(Engine engine) {
        super(engine);
    }

    @Override
    public double calculateToll() {
        return engine.getFinalToll() * 2.0;
    }
}
