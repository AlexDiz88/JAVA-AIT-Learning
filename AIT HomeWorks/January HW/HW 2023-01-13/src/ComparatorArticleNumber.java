import java.util.Comparator;

public class ComparatorArticleNumber implements Comparator<Product>, ProductsSortMethod {

    @Override
    public String name() {
        return "Сортировка по артикулу";
    }

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o1.getArticleNumber(), o2.getArticleNumber());
    }
}
