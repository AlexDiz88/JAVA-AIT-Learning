package repeat;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Duck> duckList = new ArrayList<>();

        Duck duck1 = new WhiteTailDuck();
        Duck duck2 = new RedHairDuck();
        Duck duck3 = new GreenHeadDuck();
        Duck duck4 = new BoringGrayDuck();
        Duck duck5 = new RubberDuck();
        Duck duck6 = new WoodDuck();
        Duck duck7 = new StupidDuck();
        Duck duck8 = new SmartDuck();
        Duck duck9 = new NaiveDuck();

        duckList.add(duck1);
        duckList.add(duck2);
        duckList.add(duck3);
        duckList.add(duck4);
        duckList.add(duck5);
        duckList.add(duck6);
        duckList.add(duck7);
        duckList.add(duck8);
        duckList.add(duck9);

        for (Duck d : duckList) {
            d.display();
            if (d instanceof Quackable quackable) {
                quackable.quack();
            }
            if (d instanceof Flyable flyable) {
                flyable.fly();
            }
            System.out.println("------------");
        }
    }
}
