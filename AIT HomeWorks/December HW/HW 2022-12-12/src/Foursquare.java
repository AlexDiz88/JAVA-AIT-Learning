public class Foursquare extends GeometricFigure {

    private double sideA;
    private double sideB;

    public Foursquare(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public void calculateSquare() {
        setSquare(sideA * sideB);
    }
}
