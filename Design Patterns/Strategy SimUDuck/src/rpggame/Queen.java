package rpggame;

public class Queen extends Character{

    @Override
    void fight() {
        System.out.print("Королева вступает в бой и использует ");
        this.weaponBehavior.useWeapon();
    }
}
