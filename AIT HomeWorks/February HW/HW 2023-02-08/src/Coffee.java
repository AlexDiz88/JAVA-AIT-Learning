public class Coffee {
    String title;
    Size size;
    String clientName;

    public Coffee(String title, Size size, String clientName) {
        this.title = title;
        this.size = size;
        this.clientName = clientName;
    }

    public double calculatePrice() {
        double price = 0.0;
        switch (size) {
            case SMALL -> price = 3;
            case MEDIUM -> price = 3.5;
            case BIG -> price = 4;
            case SPECIAL -> price = 5;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Order: " + size + " " + title +
                " for " + clientName + " = " + calculatePrice() + " €";
    }
}
