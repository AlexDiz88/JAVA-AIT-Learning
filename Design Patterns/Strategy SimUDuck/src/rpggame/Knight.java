package rpggame;

public class Knight extends Character{
    @Override
    void fight() {
        System.out.print("Рыцарь вступает в бой и использует ");
        this.weaponBehavior.useWeapon();
    }
}
