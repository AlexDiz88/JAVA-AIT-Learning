package task3;

public enum Fuel {
    F_95(1.57), F_98(1.76), DIESEL(1.74);

    private final double price;

    Fuel(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
