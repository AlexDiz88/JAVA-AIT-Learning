package simuduck;

public class RubberDuck extends Duck{

    public RubberDuck() {
        flyBehavior = new CantFly();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("Я Rubber simuduck.Duck - пусть и резиновая, зато желтая!");
    }
}
