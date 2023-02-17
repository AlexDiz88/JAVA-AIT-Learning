import java.util.Comparator;

public class ComparatorTitle implements Comparator<Product>, ProductsSortMethod {

    @Override
    public String name() {
        return "Сортировка по названию";
    }

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
