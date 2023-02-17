package kyu_7;

/*
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.
For example, if we run 9119 through the function, 811181 will come out, because 9^2 is 81 and 1^2 is 1.
Note: The function accepts an integer and returns an integer
 */

public class Square_Every_Digit {
    public static int squareEveryDigit(int x) {
        String str = "";
        while (x > 0) {
            str = (x % 10)*(x % 10) + str;
            x /= 10;
        }
        return Integer.parseInt(str);
    }
}
