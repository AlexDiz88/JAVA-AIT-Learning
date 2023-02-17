package OwnMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherData implements Subject {
    List<MyObserver> observers;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    public double getTemperature() {
        return new Random().nextDouble(0, 35);
    }

    public double getHumidity() {
        return new Random().nextDouble(0, 35);
    }

    public double getPressure() {
        return new Random().nextDouble(0, 35);
    }

    public void measurementsChanged() {
        System.out.println("Данные изменились");
    }

    @Override
    public void registerObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MyObserver observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        double temperature = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();
        for (MyObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
