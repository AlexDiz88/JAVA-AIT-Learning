package consult;

public class Printer<T extends Fruit> {

    T value;

    public void print() {
        System.out.println(value);
    }

    public Printer(T value) {
        this.value = value;
    }
}
