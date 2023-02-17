package ChristmasTree;

public class Ball extends TreeDecoration {
    private String color;

    public Ball() {
        super();
        int num = (int) (Math.random() * 4 + 1);
        switch (num) {
            case 1: this.color = "красный"; break;
            case 2: this.color = "синий"; break;
            case 3: this.color = "желтый"; break;
            case 4: this.color = "зеленый"; break;
        }
    }

    public void treeGlow() {
        System.out.println(color + " (" + getWeight() + "г) шарик блестит на ёлочке");
    }

    @Override
    public String toString() {
        return String.format("%-7s (%dг)", color, getWeight());
    }

    public String getColor() {
        return color;
    }
}
