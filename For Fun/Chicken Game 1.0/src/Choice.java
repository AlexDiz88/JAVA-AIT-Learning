import java.util.Scanner;

public class Choice {
    public static void inputCommand (Farmer player, Roost roost){
        Scanner mainScanner = new Scanner(System.in);
        String playerChoice = mainScanner.nextLine().trim().toLowerCase();
        choice(player, playerChoice, roost);
    }

    public static int choice(Farmer player, String playerChoice, Roost roost) {
        Chicken chicken = new Chicken();
        switch (playerChoice) {
            case "help":
            case "h":
                helpCommand(player, roost);
                break;
            case "money":
            case "m":
                System.out.println(Chicken.ANSI_GREEN + "У вас на счету: " + player.getMoney() + " $" + Chicken.ANSI_RESET);
                inputCommand(player, roost);
                break;
            case "buy":
            case "b":
                if (roost.size > 10) {
                    System.out.println("У вас уже 10 курочек");
                    System.out.println(Chicken.ANSI_CYAN + "В этой версии игры можно владеть максимум 10 курочками" + Chicken.ANSI_RESET);
                } else {
                    double chickenCost = 50;
                    if ((player.getMoney() < chickenCost) && (roost.size == 0)) {
                        System.out.println("Вы банкрот. Конец игры! Попробуйте заново.");
                        return 0;
                    }
                    Chicken newchick = new Chicken();
                    newchick.generateChicken(roost);
                    roost.addChickenToRoost(newchick);
                    player.setMoney(-chickenCost);
                    System.out.println(Chicken.ANSI_CYAN + "Вы тратите " + chickenCost + " $ на новую курочку." + Chicken.ANSI_RESET);
                    System.out.println("Вы купили замечательную курочку. Только посмотрите на неё!");
                    newchick.infoChicken();
                }
                inputCommand(player, roost);
                break;
            case "infoall":
            case "iall":
                roost.infoRoost();
                inputCommand(player, roost);
                break;
            case "feed":
            case "f":
                if (player.getMoney() < chicken.chickenFoodCost) {
                    System.out.println("Вы банкрот. Конец игры! Попробуйте заново.");
                    return 0;
                }
                chicken.feedChicken(player);
                inputCommand(player, roost);
                break;
            case "train":
            case "t":
                chicken.trainChicken();
                inputCommand(player, roost);
                break;
            case "relax":
            case "r":
                chicken.relaxChicken();
                inputCommand(player, roost);
                break;
            case "sell":
            case "s":
                player.setMoney(chicken.sellChicken());
                System.out.println(Chicken.ANSI_GREEN + "У вас на счету: " + player.getMoney() + " $" + Chicken.ANSI_RESET);
                if (player.checkGameStasus()) return 0;
                inputCommand(player, roost);
                break;
            case "exit":
                return -1;
            default:
                System.out.println("help - получить список команд");
                inputCommand(player, roost);
        }
        return 0;
    }

    public static void helpCommand(Farmer player, Roost roost){
        String[] commands = {"'help'", "'money' / 'm'", "'buy' / 'b'", "'info' / 'i'", "'feed' / 'f'", "'train' / 't'", "'relax' / 'r'", "'sell' / 's'", "'exit'"};
        System.out.println(commands[1] + " - наличные деньги игрока");
        System.out.println(commands[2] + " - купить курочку");
        System.out.println(commands[3] + " - детальная информация о курочке");
        System.out.println(commands[4] + " - покормить курочку");
        System.out.println(commands[5] + " - потренировать курочку");
        System.out.println(commands[6] + " - дать отдохнуть курочке");
        System.out.println(commands[7] + " - продать курочку");
        System.out.println(commands[8] + " - выйти из игры");
        inputCommand(player, roost);
    }
}


