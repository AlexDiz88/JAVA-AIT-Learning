package simuduck;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("SimUDuck App");
        System.out.println("-".repeat(20));
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        System.out.println("-".repeat(20));
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        System.out.println("После модификации полета:");
        modelDuck.performFly();

        System.out.println("-".repeat(20));
        DuckWhistle duckWhistle = new DuckWhistle();
        duckWhistle.performQuack();

        System.out.println("-".repeat(20));
        List<Duck> duckList = new ArrayList<>();
        duckList.add(modelDuck);
        duckList.add(mallardDuck);
        for (Duck d : duckList) {
            d.display();
            d.performFly();
        }

    }
}