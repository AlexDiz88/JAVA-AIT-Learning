package OwnMethod;

public interface Subject {

    void registerObserver(MyObserver observer);
    void removeObserver(MyObserver observer);
    void notifyObserver();

}
