package ChristmasTree;

public class Toy extends TreeDecoration{
    private String form;

    public Toy() {
        super();
        int num = (int) (Math.random() * 4 + 1);
        switch (num) {
            case 1: this.form = "кролик"; break;
            case 2: this.form = "дракон"; break;
            case 3: this.form = "хрюшка"; break;
            case 4: this.form = "тигр"; break;
        }
    }

    public void treeGlow() {
        System.out.println(form + " (" + getWeight() + "г) светится и мигает на ёлочке");
    }

    @Override
    public String toString() {
        return String.format("%-7s (%dг)", form, getWeight());
    }

    public String getForm() {
        return form;
    }
}
