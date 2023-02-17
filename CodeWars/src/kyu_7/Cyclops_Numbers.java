package kyu_7;

/*
A cyclops number is a number in binary that is made up of all 1's, with one 0 in the exact middle.
That means all cyclops numbers must have an odd number of digits for there to be an exact middle.
A couple examples:
101
11111111011111111
You must take an input, n, that will be in decimal format (base 10),
then return True if that number wil be a cyclops number when converted to binary, or False if it won't.
Assume n will be a positive integer.
 */

public class Cyclops_Numbers {
    public static boolean cyclops(long n) {
        String s = Long.toBinaryString(n);
        if (s.length() % 2 == 0) return false;
        if (s.charAt(s.length() / 2) == '1') return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && i != s.length() / 2) {
                return false;
            }
        }
        return true;
    }
}
