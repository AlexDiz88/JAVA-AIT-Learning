public class Triangle extends GeometricFigure{

    private double sideA;
    private double sideB;
    private double degree;

    public Triangle(double sideA, double sideB, double degree) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.degree = degree;
    }

    @Override
    public void calculateSquare() {
        setSquare(sideA * sideB * 0.5 * Math.sin(degree));
    }
}
