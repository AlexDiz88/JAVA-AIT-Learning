import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Farmer starttext = new Farmer();
        Roost roost = new Roost(10);
        System.out.println("Введите Ваше имя:");
        Scanner nameScanner = new Scanner(System.in);
        String playerName = nameScanner.nextLine().trim();
        Farmer player = new Farmer(playerName);
        System.out.println("Фермер " + Chicken.ANSI_CYAN + playerName + Chicken.ANSI_RESET + " удачи тебе в покорении куриного рынка!");
        System.out.println("help - получить список команд");
        Choice.inputCommand(player, roost);
    }
}