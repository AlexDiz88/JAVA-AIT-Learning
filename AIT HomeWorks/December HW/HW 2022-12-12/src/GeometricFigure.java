public class GeometricFigure {

    private double square;

    public GeometricFigure() {
    }

    public void calculateSquare() {
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "square = " + String.format("%.2f", square);
    }
}
