public class Main {
    public static void main(String[] args) {
        System.out.println("Рекурсия");
        methodA(1);
    }
    public static void methodA(int a) {
        if (a <= 5) {
            int temp = a;
            System.out.println("начали: " + temp);
            a++;
            methodA(a);
            System.out.println("закончили: " + temp);
        }
    }


}