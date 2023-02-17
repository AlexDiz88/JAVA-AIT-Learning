package repeat;

public class RubberDuck extends Duck implements Quackable{
    @Override
    public void display() {
        System.out.println("Я резиновая желтая уточка, героиня мемов");
    }

    @Override
    public void quack() {
        System.out.println("Я всех раздражаю своим писком. Пьи-пьи-пи!");
    }
}
