package Review.Q6;

abstract class Vehicle{
    protected Engine engine;

    public Vehicle(Engine engine){
        this.engine = engine;
    }

    public abstract double calculateToll();
}