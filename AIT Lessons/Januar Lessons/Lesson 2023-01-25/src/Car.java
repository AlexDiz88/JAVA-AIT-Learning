public class Car {
    private final String model;
    int price;
    private final String engineType;

    public Car(String model, int price, String engineType) {
        this.model = model;
        this.price = price;
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return model + " " + engineType + " (" + price + ")";
    }
}
