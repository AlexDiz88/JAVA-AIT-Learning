public class Main {
    public static void main(String[] args) {

        Panda p1 = new Panda("Kloosha", 1);
        Panda p2 = new Panda("Glasha", 2);
        Panda p3 = new Panda("Glasha2", 3);
        Panda.id = 100;

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

    }
}