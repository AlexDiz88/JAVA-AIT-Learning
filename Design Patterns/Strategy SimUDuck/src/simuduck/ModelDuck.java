package simuduck;

public class ModelDuck extends Duck{

    public ModelDuck() {
        flyBehavior = new CantFly();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Я не приманка. Я супермодель!");
    }
}
