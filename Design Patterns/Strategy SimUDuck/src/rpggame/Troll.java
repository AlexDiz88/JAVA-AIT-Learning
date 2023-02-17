package rpggame;

public class Troll extends Character{
    @Override
    void fight() {
        System.out.print("Тролль вступает в бой и использует ");
        this.weaponBehavior.useWeapon();
    }
}
