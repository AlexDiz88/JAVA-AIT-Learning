package repeat;

public class SmartDuck extends Duck implements Quackable{
    @Override
    public void display() {
        System.out.println("Я умная уточка! 2х2=5!");
    }

    @Override
    public void quack() {
        System.out.println("Я умею крякать, я же уточка. Кря!");
    }
}
