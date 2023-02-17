package OwnMethod;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay sd = new StatisticsDisplay(weatherData);
        ForecastDisplay fd = new ForecastDisplay(weatherData);
        weatherData.registerObserver(ccd);
        weatherData.registerObserver(sd);
        weatherData.registerObserver(fd);
        weatherData.notifyObserver();
    }
}
