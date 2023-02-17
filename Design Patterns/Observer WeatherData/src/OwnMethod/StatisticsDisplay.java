package OwnMethod;

public class StatisticsDisplay implements Display, MyObserver{

    Subject weatherData;
    double temperature;
    double humidity;
    double pressure;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Фиксирует температуру и считает средний показатель: " + temperature);
        System.out.println("Фиксирует влажность и считает средний показатель: " + humidity);
        System.out.println("Фиксирует давление и считает средний показатель: " + pressure);
        display();
    }

    @Override
    public void display() {
        System.out.println("Реализация показа статистики");
    }
}
