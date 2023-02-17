package simuduck;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Реализация пищания через класс Squeak");
    }
}
