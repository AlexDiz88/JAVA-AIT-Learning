package consult;

public class Fruit {
    String title;
    String color;

    public Fruit(String title, String color) {
        this.title = title;
        this.color = color;
    }

    @Override
    public String toString() {
        return title + " " + color;
    }
}
