package simuduck;

public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void performQuack(){
        quackBehavior.quack();
    }
    public void performFly(){
        flyBehavior.fly();
    }
    public void swim() {
        System.out.println("Плаванье обобщенной реализации из родительского класса Duck");
    }
    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }
    public void quackFlyBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public abstract void display();
}
