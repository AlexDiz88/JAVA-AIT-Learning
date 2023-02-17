public class Bag {

    Leather material;
    double leatherArea;

    public Bag(Leather material, double leatherArea) {
        this.material = material;
        this.leatherArea = leatherArea;
    }

    public double calculatePrice() {
        return material.getPriceForMeter()*leatherArea;
    }

    @Override
    public String toString() {
        return "Bag made of " + material + ", with an area of "
                + leatherArea + " = " + calculatePrice();
    }
}
