public class Observer2 implements Observer{
    @Override
    public void handleEvent(String msg) {
        System.out.println("Observer 2");
        System.out.println(msg);
        System.out.println("Ohh yeah");
    }
}
