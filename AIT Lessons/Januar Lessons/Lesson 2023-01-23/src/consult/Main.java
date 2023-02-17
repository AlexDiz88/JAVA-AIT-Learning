package consult;

public class Main {
    public static void main(String[] args) {

        Printer<Cherry> printer1 = new Printer<>(new Cherry("Вишенка", "бордовый"));
        printer1.print();



    }
}
