public class Test2 {
}

class Car{
    static int a=5;
    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.a);
        c = null;
        System.out.println(c.a);


    }
}