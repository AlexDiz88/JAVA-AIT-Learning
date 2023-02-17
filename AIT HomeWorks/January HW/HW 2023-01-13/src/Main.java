import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> assortment = new ArrayList<>();

        assortment.add(new Foodstuff(1041, "Milk", 0.79, 7));
        assortment.add(new Foodstuff(1065, "Bread", 1.40, 1));
        assortment.add(new Clothes(1012, "Shirt", 25));
        assortment.add(new Clothes(1042, "Jeans", 19));
        assortment.add(new Electronics(1051, "TV", 699));
        assortment.add(new Smartphones(1028, "Smartphone", 500));

        System.out.println("Список товаров до сортировки:");
        for (Product p: assortment) {
            System.out.println(p);
        }

        System.out.println("-----------------------");
        List<ProductsSortMethod> productsSortMethodList = new ArrayList<>();
        productsSortMethodList.add(new ComparatorArticleNumber());
        productsSortMethodList.add(new ComparatorTitle());
        productsSortMethodList.add(new ComparatorPrice());

        ChooseSortMethod csm = new ChooseSortMethod(productsSortMethodList);
        csm.sort(assortment);
        System.out.println("Список товаров после сортировки:");
        for (Product p: assortment) {
            System.out.println(p);
        }
    }
}
