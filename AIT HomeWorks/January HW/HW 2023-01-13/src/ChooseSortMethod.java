import java.util.List;
import java.util.Scanner;

public class ChooseSortMethod {

    private List<ProductsSortMethod> sortMethods;

    public ChooseSortMethod(List<ProductsSortMethod> sortMethods) {
        this.sortMethods = sortMethods;
    }

    public void sort(List<Product> list) {
        System.out.println("Выберите способ сортировки товаров:");
        for (int i = 0; i < sortMethods.size(); i++) {
            System.out.println((i + 1) + ". " + sortMethods.get(i).name());
        }
        Scanner scanner = new Scanner(System.in);
        int sortChoice = scanner.nextInt();
        switch (sortChoice) {
            case 1 -> list.sort(new ComparatorArticleNumber());
            case 2 -> list.sort(new ComparatorTitle());
            case 3 -> list.sort(new ComparatorPrice());
            default -> System.out.println("Неверный способ сортировки. Лист не отсортирован");
        }
    }
}
