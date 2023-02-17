public abstract class Product {
    private final int articleNumber;
    private final String title;
    private final double price;

    public Product(int articleNumber, String title, double price) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-4d %10s: %6.2f $.   ", articleNumber, title, price);
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
