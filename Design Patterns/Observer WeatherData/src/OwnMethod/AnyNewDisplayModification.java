package OwnMethod;

public class AnyNewDisplayModification implements Display, MyObserver {

    // все что нужно для новой опции приложения - имплементировать интерфейсы Display и MyObserver
    // и добавить этот класс в качестве наблюдателя у нашего субъекта (метеостанции), например через конструктор

    Subject weatherData;

    public AnyNewDisplayModification(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("какаято реализация");
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("какаято реализация");
    }

}
