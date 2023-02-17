package simuduck;

public class DuckWhistle{

    private QuackBehavior quackBehavior;

    public DuckWhistle() {
        this.quackBehavior = new Whistle();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }
}
