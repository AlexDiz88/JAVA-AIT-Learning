import java.util.Scanner;

public class Chicken {
    private String name;
    private int weight;
    private boolean classification;
    private double price;
    private double bonusPrice;
    private boolean isHungry;
    public int countChicken;
    public double chickenFoodCost = 3;
    private boolean isAlive;
    private boolean isTired;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Chicken() {
    }

    public void generateChicken(Roost roost) {
        Chicken chicken = new Chicken();
        roost.addChickenToRoost(chicken);
        isAlive = true;
        isHungry = true;
        isTired = false;
        countChicken++;
        int minWeight = 300;
        int maxWeight = 500;
        System.out.println("Придумайте имя для курочки");
        Scanner mainScanner = new Scanner(System.in);
        name = mainScanner.nextLine();
        weight = (int) (minWeight + Math.random() * (maxWeight - minWeight + 1));
        if (weight % 3 == 0) {
            classification = true;
        } else {
            classification = false;
        }
    }

    public void infoChicken() {
        if (!statusCheck()) return;
        System.out.println("***Инфо о курочке***");
        System.out.println("Имя : " + name);
        System.out.println("Вес : " + weight + " гр.");
        System.out.print("Сорт : ");
        System.out.println((classification) ? "Особая" : "Обычная");
        System.out.print("Питание: ");
        System.out.println((isHungry) ? "Голодная" : "Сытая");
        System.out.print("Форма: ");
        System.out.println((isTired) ? "Уставшая" : "Отдохнувшая");
        price = chickenPrice();
        System.out.println("Цена : " + String.format("%.2f", price) + " $");
        System.out.println("---------------------");
    }

    public void feedChicken(Farmer player) {
        if (!statusCheck()) return;
        player.setMoney(-chickenFoodCost);
        System.out.println(ANSI_GREEN + "Вы тратите " + chickenFoodCost + " $ на корм." + ANSI_RESET);
        if (!isHungry) {
            System.out.println("Курочка " + name + " уже сытая. Она отказывается от еды.");
            System.out.println("---------------------");
        }
        if (isHungry) {
            int minWeightChange = 150;
            int maxWeightChange = 225;
            int bonusWeight = (int) (minWeightChange + Math.random() * (maxWeightChange - minWeightChange + 1));
            int foodQuality = checkQualityFood();
            if (foodQuality == 0) {
                weight += bonusWeight;
                System.out.println("Курочка " + name + " вкусно кушает и толстеет на +" + bonusWeight + " гр.");
                System.out.println("Новый вес " + name + ": " + weight + " гр.");
                System.out.println("---------------------");
                isHungry = false;
            }
            if (foodQuality == 1) {
                weight -= bonusWeight / 2;
                System.out.println("Её стошнило и она похудела на -" + (bonusWeight / 2) + " гр.");
                System.out.println("Новый вес " + name + ": " + weight + " гр.");
                System.out.println("---------------------");
                isHungry = false;
            }
            if (foodQuality == 2) {
                System.out.println("Покойся с миром курочка");
                System.out.println("---------------------");
                weight = 0;
                countChicken--;
                isAlive = false;
            }
        }
    }

    public int checkQualityFood() {
        int min = 0;
        int max = 100;
        int qualityResult = (int) (min + Math.random() * (max - min + 1));
        if (qualityResult <= 3) {
            System.out.println(ANSI_RED + "Курочка подавилась зёрнышком и умерла :´( " + ANSI_RESET);
            return 2;
        }
        if (qualityResult > 3 && qualityResult <= 13) {
            System.out.println(ANSI_YELLOW + "Курочка cъела плохой корм." + ANSI_RESET);
            return 1;
        }
        return 0;
    }

    public void trainChicken() {
        if (!statusCheck()) return;
        if (isTired) {
            System.out.println("Ваша курочка устала. Она не в силах больше тренироваться.");
            return;
        }
        int min = 0;
        int max = 100;
        int qualityResult = (int) (min + Math.random() * (max - min + 1));
        if (qualityResult <= 15) {
            int muscleBonus = 20;
            weight += weight * 20 / 100;
            System.out.println("Курочка " + name + " проводит супер-тренировку и увеличивается на +" + muscleBonus + "%");
            System.out.println("Новый вес " + name + ": " + weight + " гр.");
            System.out.println("---------------------");
        } else {
            int minWeightChange = 30;
            int maxWeightChange = 50;
            int bonusWeight = (int) (minWeightChange + Math.random() * (maxWeightChange - minWeightChange + 1));
            weight -= bonusWeight;
            System.out.println("Курочка " + name + " бегает, прыгает, отжимается и худеет на -" + bonusWeight + " гр.");
            System.out.println("Новый вес " + name + ": " + weight + " гр.");
        }
        isTired = true;
        isHungry = true;
    }

    public void relaxChicken() {
        if (!statusCheck()) return;
        isTired = false;
        System.out.println("Ваша курочка прекрасно проводит время и полностью восстанавливает силы");
        System.out.println("---------------------");
    }

    public double sellChicken() {
        if (!statusCheck()) return 0;
        countChicken--;
        price = chickenPrice();
        double sellPrice = price;
        System.out.println(ANSI_CYAN + "Вы продали свою курочку за " + String.format("%.2f", sellPrice) + " $" + ANSI_RESET);
        weight = 0;
        name = "";
        classification = false;
        return sellPrice;
    }

    public boolean statusCheck() {
        if (!isAlive) {
            System.out.println("Вашей курочки нет в живых. Купите новую");
            System.out.println("---------------------");
            return false;
        }
        if (countChicken < 1) {
            System.out.println("У Вас нет курочки. Купите новую.");
            return false;
        }
        return true;
    }

    public double chickenPrice() {
        if (classification) bonusPrice = 1.2;
        else bonusPrice = 1;
        double resultPrice = weight / 10 * bonusPrice;
        if (weight < 500) resultPrice *= 0.4;
        if (weight >= 500 && weight < 800) resultPrice *= 0.7;
        if (weight >= 800 && weight < 1100) resultPrice *= 1.1;
        if (weight >= 1100 && weight < 1300) resultPrice *= 1.75;
        if (weight >= 1300 && weight < 1600) resultPrice *= 1.35;
        if (weight >= 1600 && weight < 2000) resultPrice *= 0.85;
        if (weight >= 2000) resultPrice *= 0.5;
        return resultPrice;
    }
}

