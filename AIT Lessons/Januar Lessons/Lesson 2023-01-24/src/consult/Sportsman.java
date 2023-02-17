package consult;

public class Sportsman {

    public boolean isWarmedUp;

    public void warmUp() {
        isWarmedUp = true;
    }

    public void runTenMiles() throws SportsmanWarmUpException {
        if (isWarmedUp) {
            System.out.println("Успешно пробежал пробежку");
        } else {
            throw new SportsmanWarmUpException("Спортсмен не готов");
        }
    }
}
