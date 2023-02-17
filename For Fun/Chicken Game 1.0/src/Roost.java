public class Roost {
    private Chicken[] chicks;
    public int size;

    public Roost(int capacity){
        chicks = new Chicken[capacity];
    }

    public boolean addChickenToRoost(Chicken chicken){
        if (size < chicks.length){
            chicks[size] = chicken;
            size++;
            return true;
        }
        return false;
    }

    public boolean removeChickenFromRoost(Chicken chicken){
        for (int i = 0; i < size; i++) {
            if (chicks[i].equals(chicken)){
                chicks[i]=chicks[size-1];
                size--;
                return true;
            }
        }
        return false;
    }

    public void infoRoost(){
        for (int i = 0; i < size; i++) {
            System.out.println(chicks[i]);

        }
    }

}
