public enum Leather {
    COW(50), CROCODILE(1000),  SHEEP(70), FISH(500);

    private final int priceForMeter;

    Leather(int priceForMeter) {
        this.priceForMeter = priceForMeter;
    }

    public int getPriceForMeter() {
        return priceForMeter;
    }
}
