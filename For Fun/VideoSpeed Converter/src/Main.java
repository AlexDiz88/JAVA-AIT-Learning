/**
 * VideoSpeed Converter 1.0
 *
 * @ created by Alex_JavaCat
 * 2023-01-31
 */

public class Main {
    public static void main(String[] args) {

        // Введите время в формате ЧЧ:ММ / Ч:ММ / ММ
        // укажите коэф.скорости видео

        // TODO попрактиковаться реализовать через String
        /*
        String time = "14";
        String time2 = ":15";
        String time3 = "2:";
        String time4 = "2:1";
        String time5 = "2:21";
        String time6 = "2:211";
        String time6 = "2:21:11";
        String time7 = ":";
        String time8 = "2:21d";
        String time9 = "2d:21";
        String time10 = "2d:21d";
        String time11 = "d:d";
        String time12 = "dd";
        String time13 = "1:d:d";
        String time14 = "1%15";
        */
        int hours = 1;
        int minutes = 25;
        double speed = 1.30;

        convertTime(hours, minutes, speed);
    }

    private static void convertTime(int hours, int minutes, double speed) {
        double res = (hours*60 + minutes) / speed;
        System.out.println(String.format("%.1f", res) + " minutes");
    }
}