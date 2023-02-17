package rpggame;

public class BowAndArrowsBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("Выстрел из лука");
    }
}
