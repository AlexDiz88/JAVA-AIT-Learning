public class MyClass {
    String message;
    double value;

    public MyClass(String message, double value) {
        this.message = message;
        this.value = value;
    }

    @Override
    public String toString() {
        return message + " " + value;
    }
}
