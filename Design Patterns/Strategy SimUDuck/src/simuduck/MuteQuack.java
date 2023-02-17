package simuduck;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Некоторым уткам запрещено открывать рот... точнее клюв (класс MuteQuack)");
    }
}
