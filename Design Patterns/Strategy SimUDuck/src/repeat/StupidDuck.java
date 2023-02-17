package repeat;

public class StupidDuck extends Duck implements Flyable{
    @Override
    public void display() {
        System.out.println("Я глупая уточка. Ы!");
    }

    @Override
    public void fly() {
        System.out.println("Летящая утка - опасный снаряд! Ю-ху-ууу! ПА-ЛИ-ТЕ-ЛИ!");
    }
}
