package kyu_7;

/*
Write function heron which calculates the area of a triangle with sides a, b, and c (x, y, z in COBOL).

Heron's formula:
sqrt {s * (s - a) * (s - b) * (s - c)}
where
s=(a+b+c)/2
Output should have 2 digits precision.
 */

import java.text.DecimalFormat;

public class Herons_formula {
    public static double heron(double a, double b, double c) {
        double s = (a+b+c)/2;
        double res = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return Double.parseDouble(String.format("%.2f", res).replace(",","."));
    }
}
