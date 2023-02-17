package kyu_7;

/*
Given a string str, reverse it and omit all non-alphabetic characters.

Example
For str = "krishan", the output should be "nahsirk".
For str = "ultr53o?n", the output should be "nortlu".
A string consists of lowercase latin letters, digits and symbols.
 */

public class Simple_Fun_176 {
    public static String reverseLetter(final String str) {
        String s = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isLetter(str.charAt(i))) {
                s += str.charAt(i);
            }
        }
        return s;
    }
}
