package fromAlisher.drinks;

public class Bar<T extends Drink & Natural> {
    String title;
    String address;
    T drinks;

    public Bar(String title, String address, T drinks) {
        this.title = title;
        this.address = address;
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return title + " " + address + " " + drinks;
    }
}
