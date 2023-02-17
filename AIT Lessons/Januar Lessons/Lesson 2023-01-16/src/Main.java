public class Main {
    public static void main(String[] args) {
        ObserverClass observerClass = new ObserverClass();
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        observerClass.addObserver(observer1);
        observerClass.addObserver(observer2);

        observerClass.setObservedState("hello");
    }
}