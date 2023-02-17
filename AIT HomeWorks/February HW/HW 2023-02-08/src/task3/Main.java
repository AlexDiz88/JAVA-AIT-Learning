/*
Создайте enum Fuel
С полем double price.
Пусть будет несколько типов топлива:
Бензин 95 по цене 1,57 за литр
Бензин 98 по цене 1.76 за литр
Дизель по цене 1,74 за литр
Создайте класс автомобиль с полями:
Название;
Объем бака в литрах;
Fuel fuel Тип топлива.
Пусть у автомобиля будет метод - рассчитать стоимость полного бака,
он должен расчитывать сколько стоит заправить полный бак.
 */

package task3;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Opel", 55, Fuel.F_95);
        Car car2 = new Car("BMW", 65, Fuel.DIESEL);
        Car car3 = new Car("Dodge", 90, Fuel.F_98);

        System.out.println(car1.calculateFullTanking());

    }
}
