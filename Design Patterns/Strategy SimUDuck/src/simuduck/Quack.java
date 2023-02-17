package simuduck;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Реализация кряканья через класс Quack");
    }
}
