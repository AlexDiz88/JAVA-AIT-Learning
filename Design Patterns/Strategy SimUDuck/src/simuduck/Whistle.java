package simuduck;

public class Whistle implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Этот звук привлекает только самых красивых уточек");
    }
}
