package simuduck;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Утки с крыльями могут облететь всю планету");
    }
}
