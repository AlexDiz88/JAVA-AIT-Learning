package rpggame;

public class King extends Character{
    @Override
    void fight() {
        System.out.print("Король вступает в бой и использует ");
        this.weaponBehavior.useWeapon();
    }
}
