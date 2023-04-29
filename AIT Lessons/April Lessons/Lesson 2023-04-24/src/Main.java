import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // реализация через класс
        ClassImplPrinter printer = new ClassImplPrinter();
        theMethodUsesPrinter(printer, "Text");

        // реализация через лямбду
        Printer printer1 = (String str) -> {
            System.out.println("Lambda realisation");
            System.out.println(str);
        };

        theMethodUsesPrinter(str -> System.out.println("str: " + str), "Сразу через метод");

        theMethodUsesConsumer(str -> System.out.println("str: " + str), "Через Consumer");

        List.of("First", "Second", "Third").forEach(s -> System.out.println(s));

        // stream.count
        System.out.println(List.of("First", "Second", "Third").stream().count());

        // filter
        System.out.println("//////////////////////////////////////////////////");
        long res = List.of("a", "aa", "aaa", "aaaa", "aaaaa")
                .stream()
                .filter(s -> s.length() >= 4)
                .map(s -> {
                    System.out.println("xxxxxx");
                    return s + 1;
                }).count();

    }

    public static void theMethodUsesPrinter(Printer printer, String msg) {
        printer.print(msg);
    }

    public static void theMethodUsesConsumer(Consumer<String> printer, String msg) {
        printer.accept(msg);
    }
}