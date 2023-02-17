import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // простой метод получения случайного числа double в диапазоне (0..1) не включая 1
        double rnd1 = Math.random();
        System.out.println("rnd1 = " + rnd1);

        // тип double можно кастить в int/short/byte но мы всегда будем получать 0, из-за диапазона метода Math.random()
        int rnd2 = (int) Math.random();
        short rnd3 = (short) Math.random();
        byte rnd4 = (byte) Math.random();
        System.out.println("rnd2 = " + rnd2);
        System.out.println("rnd3 = " + rnd3);
        System.out.println("rnd4 = " + rnd4);

        // формула для получения целого числа в диапазоне (0..(n-1))
        int n = 10;
        int rnd5 = (int) (Math.random() * n);
        System.out.println("rnd5 = " + rnd5);

        // формула для получения целого числа в диапазоне (min..max) включая max!
        int min = 15; int max = 30;
        int rnd6 = (int) (min + Math.random() * (max - min + 1));
        System.out.println("rnd6 = " + rnd6);

        // Если диапазон большой и выходит за пределы значений типа, то нужно использовать преобразование в более широкий тип:
        // Например, вот формула для получения целого числа int в диапазоне (Integer.MIN_VALUE....Integer.MAX_VALUE)
        int rnd7 = (int) (Integer.MIN_VALUE + Math.random() * ((long)Integer.MAX_VALUE - Integer.MIN_VALUE + 1));
        System.out.println("rnd7 = " + rnd7);
        System.out.println("----------");

        // Существует встроенный класс Random (с набором методов для получения псевдослучайных чисел)
        Random random = new Random(); // создание объекта класса рандом
        Random random2 = new Random(System.nanoTime()); // 2й конструктор с указанием сида. В циклах существует вероятность совпадения времени для сида
        int r1 = random.nextInt(); // получение случайного целого числа int
        System.out.println("r1 = " + r1);
        double r2 = random.nextDouble(); // получение случайного дробного числа double
        System.out.println("r2 = " + r2);


    }
}