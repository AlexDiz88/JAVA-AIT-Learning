package OwnMethod;

public class ForecastDisplay implements Display, MyObserver{

    Subject weatherData;
    double temperature;
    double humidity;
    double pressure;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Реализация прогноза погоды");
        display();
    }

    @Override
    public void display() {
        System.out.println("Реализация показа прогноза в приложении");
    }
}
