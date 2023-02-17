public class Panda {
    public String name;
    public static int id;

    public Panda(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }
}
