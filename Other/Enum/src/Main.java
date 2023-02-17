/*
Создайте enum Size с четырьмя размерами: SMALL, MEDIUM, BIG, SPECIAL
        Создайте класс кофе Coffee с полями:
            - название String title;
            - размер Size size;
            - для кого кофе String clientName;

        Пусть у кофе будет метод:
            - double calculatePrice() - метод возвращает стоимость кофе
                маленький кофе - 3 евро;
                средний - 3,5;
                большой - 4;
                специальный - 5;
*/

/*
Нужно создать enum Leather
 c полем int price - цена за метр квадратный
    Cow - стоит 50
    Crocodile - стоит 1000
    Sheep - 70
    Fish - 500
Сделать класс Сумка Bag c полями:
    Leather material;
    double leatherArea; - площадь материала
Пусть у сумки будет метод
   calculatePrice()
   рассчитывает стоимость из расчета площадь, умноженная на стоимость материала.
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enum");
        System.out.println("-----Coffee-Shop-----");
        Coffee cup1 = new Coffee("Espresso", Size.SMALL, "Andrew");
        Coffee cup2 = new Coffee("Cappuccino", Size.MEDIUM, "Matt");
        Coffee cup3 = new Coffee("Espresso", Size.BIG, "Joe");
        Coffee cup4 = new Coffee("Espresso", Size.SPECIAL, "Daniel");
        List<Coffee> orders = List.of(cup1, cup2, cup3, cup4);
        for (Coffee order : orders) {
            System.out.println(order);
        }

        System.out.println("-----Leather Bags-----");
        Bag bag1 = new Bag(Leather.SHEEP, 2.5);
        Bag bag2 = new Bag(Leather.COW, 10);
        Bag bag3 = new Bag(Leather.FISH, 3.25);
        Bag bag4 = new Bag(Leather.CROCODILE, 1.5);
        List<Bag> bags = List.of(bag1, bag2, bag3, bag4);
        for (Bag bag : bags) {
            System.out.println(bag);
        }

    }
}