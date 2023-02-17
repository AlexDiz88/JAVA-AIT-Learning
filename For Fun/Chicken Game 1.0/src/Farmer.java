public class Farmer {
    private double money;
    String playerName;


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money += money;
    }

    public Farmer() {
        System.out.println("Добро пожаловать в игру \"Куриный фермер\" (ver. 1.0 made by Alex)");
        System.out.println("Цель игры - заработать 500 $ на продаже курочек.");
        System.out.println("ПРАВИЛА:");
        System.out.println("- Чем идеальнее вес курочки, тем выше её цена на рынке.");
        System.out.println("- Слишком худые или слишком жирные курицы сильно теряют в цене.");
        System.out.println("- Чтобы сбросить вес, курочка должна потренироваться и сжечь калории.");
        System.out.println("- Чтобы курочка стала жирной, её нужно кормить.");
        System.out.println("- Курочка не станет кушать, если она уже сытая.");
        System.out.println("- Чтобы курочка стала голодная, она должна побегать и попрыгать.");
        System.out.println("- Во время тренировки, вместо похудения, курочка может существенно нарастить мышечную массу(шанс 15%).");
        System.out.println("- Чтобы тренировать курочку, она должна быть отдохнувшая.");
        System.out.println("- Курочке может попастся плохой корм и её стошнит (шанс 10% при кормлении).");
        System.out.println("- Курочка может подавится и умереть (шанс 3% при кормлении).");
        System.out.println("- Можно купить новую курочку, если предыдущая умерла или Вы её продали.");
        System.out.println("- Любая курочка с 33% шансом при покупке станет особой. Её цена на рынке выше на 20%.");
        System.out.println("- Все значения прироста/уменьшения веса случайны (но в заданном фиксированном диапазоне).");
        System.out.println("- Игра находится на стадии разработки и в ней вы скорее всего встретите баги");
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public Farmer(String playerName) {
        this.playerName = playerName;
        money = 100;
    }

    public boolean checkGameStasus() {
        if (money > 500) {
            System.out.println(Chicken.ANSI_CYAN + "--------------------ПОБЕДА!----------------------");
            System.out.println("-----У ТЕБЯ ПОЛУЧИЛОСЬ РАЗБОГАТЕТЬ НА КУРОЧКАХ-----");
            System.out.println(Chicken.ANSI_YELLOW + playerName + Chicken.ANSI_CYAN + " - ТЫ ЛУЧШИЙ КУРИНЫЙ ФЕРМЕР ИЗ ВСЕХ КОГО Я ЗНАЮ!!!" + Chicken.ANSI_RESET);
            System.out.println("конец игры");
            return true;
        }
        return false;
    }
}

