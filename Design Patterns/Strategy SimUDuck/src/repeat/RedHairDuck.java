package repeat;

public class RedHairDuck extends Duck implements Flyable, Quackable{
    @Override
    public void display() {
        System.out.println("Я не рыжая, а красная! И это мой натуральный цвет!!");
    }

    @Override
    public void fly() {
        System.out.println("Летящая утка - опасный снаряд! Ю-ху-ууу! ПА-ЛИ-ТЕ-ЛИ!");
    }

    @Override
    public void quack() {
        System.out.println("Я умею крякать, я же уточка. Кря!");
    }
}
