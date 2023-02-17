public class Foodstuff extends Product {
    int storageLife;

    public Foodstuff(int articleNumber, String title, double basePrice, int storageLife) {
        super(articleNumber, title, basePrice);
        this.storageLife = storageLife;
    }
}
