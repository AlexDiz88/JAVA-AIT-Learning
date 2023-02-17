package consult;

public class Panda {
    public String name;
    public double weight;

    public static final int numberOfColors = 2;
    public static int pandasPopulation = 0;

    public Panda(String name, double weight) {
        this.name = name;
        this.weight = weight;
        pandasPopulation++;
    }

    public void introduce() {
        System.out.println("Hi, dear Sir, my name is " + name + ". My weight is " + weight);
    }

    public static void introduce(Panda panda) {
        System.out.println("STATIC! Hi, dear Sir, my name is " + panda.name + ". My weight is " + panda.weight);
    }
}
