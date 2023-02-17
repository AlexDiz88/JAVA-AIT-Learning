public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(32.4);
        c1.calculateSquare();
        System.out.println(c1);
        Foursquare f1 = new Foursquare(12, 4);
        f1.calculateSquare();
        System.out.println(f1);
        Triangle t1 = new Triangle(7,11, 45);
        t1.calculateSquare();
        System.out.println(t1);
    }
}
