package consult;

public class Main {
    public static void main(String[] args) {
        Panda stepan = new Panda("Stepan", 160);
        System.out.println(Panda.pandasPopulation);
        stepan.introduce();
        Panda.introduce(stepan);

        // Exceptions
        // try, catch, finally, throw, throws

        Sportsman igor = new Sportsman();
        //igor.warmUp();
        try {
            igor.runTenMiles();
        } catch (SportsmanWarmUpException e) {
            System.out.println(e.getMessage());
        }




    }
}
