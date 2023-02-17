package rpggame;

public class Main {
    public static void main(String[] args) {

        Character character1 = new King();
        Character character2 = new Queen();
        Character character3 = new Troll();
        Character character4 = new Knight();

        character1.setWeaponBehavior(new BowAndArrowsBehavior());
        character2.setWeaponBehavior(new KnifeBehavior());
        character3.setWeaponBehavior(new AxeBehavior());
        character4.setWeaponBehavior(new SwordBehavior());

        character1.fight();
        character2.fight();
        character3.fight();
        character4.fight();
    }
}
