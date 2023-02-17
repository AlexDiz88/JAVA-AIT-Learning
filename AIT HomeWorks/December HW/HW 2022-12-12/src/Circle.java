public class Circle extends GeometricFigure {

    private final double PI =3.1415926535;
    private double diameter;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.diameter = radius*2;
    }

    @Override
    public void calculateSquare() {
        setSquare(PI * radius * radius);
    }
}
