package ChristmasTree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // создаем ArrayList для шариков
        ArrayList<Ball> balls = new ArrayList<>();

        // создаем 20 случаных по весу и цвету шариков и добавляем их в ArrayList
        for (int i = 0; i < 20; i++) {
            balls.add(new Ball());
        }

        // по аналогии создаем 20 игрушек и добавляем их во второй ArrayList
        ArrayList<Toy> toys = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            toys.add(new Toy());
        }

        // удаляем с помощью метода remove() все зеленые шарики и фигурки тигров
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).getColor().equals("зеленый")) {
                balls.remove(i);
                i--;
            }
        }

        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getForm().equals("тигр")) {
                toys.remove(i);
                i--;
            }
        }

        // Создаем общий ArrayList для всех оставшихся шариков и игрушек
        ArrayList<TreeDecoration> christmasTree = new ArrayList<>();
        christmasTree.addAll(balls);
        christmasTree.addAll(toys);

        // удаляем шарики и игрушки весом 10 грамм
        for (int i = 0; i < christmasTree.size(); i++) {
            if (christmasTree.get(i).getWeight() == 10) {
                christmasTree.remove(i);
                i--;
            }
        }

        // вызываем метод "Ёлочка, гори!" - treeGlow() для каждого шарика и игрушки, с помощью cast до нужных классов
        int counter = 1;
        for (TreeDecoration d : christmasTree) {
            if (d instanceof Ball) {
                System.out.print(counter + 1 + ". ");
                ((Ball) d).treeGlow();
            }
            if (d instanceof Toy) {
                System.out.print(counter + 1 + ". ");
                ((Toy) d).treeGlow();
            }
            counter++;
        }
    }
}
