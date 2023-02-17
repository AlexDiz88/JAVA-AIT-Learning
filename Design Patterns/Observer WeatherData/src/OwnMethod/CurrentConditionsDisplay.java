package OwnMethod;

public class CurrentConditionsDisplay implements Display, MyObserver{

    Subject weatherData;
    double temperature;
    double humidity;
    double pressure;
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity, " + pressure + " mm");
    }
}
