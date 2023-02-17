package kyu_7;

/*
The Collatz Conjecture states that for any positive natural number n, this process:

if n is even, divide it by 2
if n is odd, multiply it by 3 and add 1
repeat
will eventually reach n = 1.

For example, if n = 20, the resulting sequence will be:

[ 20, 10, 5, 16, 8, 4, 2, 1 ]
Write a program that will output the length of the Collatz Conjecture for any given n.
In the example above, the output would be 8.
 */

public class Collatz_Conjecture_Length {
    public static long conjecture(long x) {
        if (x <= 0) return 0;
        long counter = 1;
        while (x > 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = x * 3 + 1;
            }
            counter++;
        }
        return counter;
    }
}
