package rpggame;

public abstract class Character {

    protected WeaponBehavior weaponBehavior;

    public void setWeaponBehavior(WeaponBehavior wb) {
        this.weaponBehavior = wb;
    }

    abstract void fight();
}
