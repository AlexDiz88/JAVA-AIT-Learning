package ChristmasTree;

public abstract class TreeDecoration {
    private int weight;

    public TreeDecoration() {
        int minWeight = 5;
        int maxWeight = 10;
        this.weight = (int) (minWeight + Math.random() * (maxWeight - minWeight + 1));
    }

    public int getWeight() {
        return weight;
    }
}
