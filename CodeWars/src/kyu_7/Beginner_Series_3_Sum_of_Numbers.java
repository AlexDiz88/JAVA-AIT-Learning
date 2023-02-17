package kyu_7;

/*
Given two integers a and b, which can be positive or negative, find the sum of all the integers between and including them and return it. If the two numbers are equal return a or b.
Note: a and b are not ordered!

Examples (a, b) --> output (explanation)
(1, 0) --> 1 (1 + 0 = 1)
(1, 2) --> 3 (1 + 2 = 3)
(0, 1) --> 1 (0 + 1 = 1)
(1, 1) --> 1 (1 since both are same)
(-1, 0) --> -1 (-1 + 0 = -1)
(-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)
Your function should only return a number, not the explanation about how you get that number.
 */

public class Beginner_Series_3_Sum_of_Numbers {
    public static int getSum(int a, int b) {
        if (a == b) return a;
        int res = 0;
        if (a < b) {
            for (int i = a; i <= b; i++) {
                res += i;
            }
        }
        if (a > b) {
            for (int i = b; i <= a; i++) {
                res += i;
            }
        }
        return res;
    }
}
