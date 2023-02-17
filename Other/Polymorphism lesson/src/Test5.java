public class Test5 {
    public static void main(String[] args) {
        Test10 t = new Test10();
        t.abc();

    }
}

class Test10{
    int a=5;
    void abc(){System.out.println("ok1");}
}

class Test20 extends Test10{
    int a=15;
    void abc(){System.out.println("ok2");}
}

class Test30 extends Test20{
    int a=25;
    void abc(){System.out.println("ok3");}
    public static void main(String[] args) {
        Test30 t = new Test30();
        System.out.println(((Test20) t).a);
        ((Test20)t).abc();
    }
}

