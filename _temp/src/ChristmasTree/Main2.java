package ChristmasTree;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {

        // альтернативное решение с одним ArrayList для всех украшений

        ArrayList<TreeDecoration> christmasTree = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            christmasTree.add(new Ball());
            christmasTree.add(new Toy());
        }

        for (int i = 0; i < christmasTree.size(); i++) {
            if (christmasTree.get(i) instanceof Ball) {
                if (((Ball) christmasTree.get(i)).getColor().equals("зеленый") || christmasTree.get(i).getWeight() == 10) {
                    christmasTree.remove(i);
                    i--;
                    continue;
                }
                System.out.print(i + 1 + ". ");
                ((Ball) christmasTree.get(i)).treeGlow();
            }
            if (christmasTree.get(i) instanceof Toy) {
                if (((Toy) christmasTree.get(i)).getForm().equals("тигр") || christmasTree.get(i).getWeight() == 10) {
                    christmasTree.remove(i);
                    i--;
                    continue;
                }
                System.out.print(i + 1 + ". ");
                ((Toy) christmasTree.get(i)).treeGlow();
            }
        }
    }
}
