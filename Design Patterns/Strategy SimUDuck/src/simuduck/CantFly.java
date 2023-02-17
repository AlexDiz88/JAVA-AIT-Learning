package simuduck;

public class CantFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Есть утки, которым небо только снится");
    }
}
