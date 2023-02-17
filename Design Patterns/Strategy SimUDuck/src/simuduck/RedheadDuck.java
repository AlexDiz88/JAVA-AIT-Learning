package simuduck;

public class RedheadDuck extends Duck{

    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Я simuduck.RedheadDuck. Ну почему же крашена? Это мой натуральный цвет");
    }
}
