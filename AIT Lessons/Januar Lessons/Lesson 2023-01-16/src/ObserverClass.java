import java.util.ArrayList;
import java.util.List;

public class ObserverClass implements Observable{
    private List<Observer> observerList = new ArrayList<>();
    private String observedState;

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer observer : observerList) {
            observer.handleEvent(msg);
        }
    }

    public void setObservedState(String observedState) {
        System.out.println("Поле изменило значение:");
        notifyObserver( "было: " + this.observedState);
        this.observedState = observedState;
        notifyObserver( "стало: " + this.observedState);
    }
}
