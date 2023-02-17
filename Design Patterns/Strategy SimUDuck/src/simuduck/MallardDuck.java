package simuduck;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Я Mallard simuduck.Duck - по-настоящему дикая уточка!");
    }
}
