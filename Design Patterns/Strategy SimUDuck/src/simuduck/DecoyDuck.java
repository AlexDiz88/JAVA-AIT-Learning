package simuduck;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        flyBehavior = new CantFly();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("Я - Подсадная утка. Не летаю и не крякаю. Зачем так жить?(((");
    }
}
