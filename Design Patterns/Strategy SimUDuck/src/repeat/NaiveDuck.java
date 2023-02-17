package repeat;

public class NaiveDuck extends Duck implements Flyable, Quackable{
    @Override
    public void display() {
        System.out.println("Я наивная уточка. А ты правда на мне женишься?");
    }

    @Override
    public void quack() {
        System.out.println("Я всех раздражаю своим писком. Пьи-пьи-пи!");
    }

    @Override
    public void fly() {
        System.out.println("Летящая утка - опасный снаряд! Ю-ху-ууу! ПА-ЛИ-ТЕ-ЛИ!");
    }
}
