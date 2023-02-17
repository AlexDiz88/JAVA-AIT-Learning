package task3;

public class Car {

    private final String title;
    private final int tankCapacity;
    private final Fuel fuel;

    public Car(String title, int tankCapacity, Fuel fuel) {
        this.title = title;
        this.tankCapacity = tankCapacity;
        this.fuel = fuel;
    }

    public double calculateFullTanking() {
        return tankCapacity*fuel.getPrice();
    }

    @Override
    public String toString() {
        return "Car{" +
                "title='" + title + '\'' +
                ", tankCapacity=" + tankCapacity +
                ", fuel=" + fuel +
                '}';
    }
}
