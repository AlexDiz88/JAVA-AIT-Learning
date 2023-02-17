package kyu_7;

/*
Prince Arthas needs your help! Mal'ganis has spread an infection amongst the Stratholme citizens,
and we must help Arthas prevent this infection from spreading to other parts of the Kingdom.
You will receive a string s as input: Each "word" represents a house, and each letter represents a citizen.
All infected citizens are represented as "i" or "I" in s. You must eradicate them, and their neighbors.
If an infected citizen appears after or before a space, you should not delete the space,
but keep in mind that the distance from "house" to "house" (word to word) has to have only one space.

EXAMPLES:
"STRING"                       -> "STG"
"1i2 33 i4i5 i555ii5"          -> "33 5"
"It is a bit chilly"           -> "a cly"
"Pineapple pizza is delicious" -> "eapple za deus"
"It is not there"              -> "not there"
NOTES:
There are no apostrophes or any non-alphanumeric characters other than spaces.
Make sure there are no leading or trailing spaces in the result string
You will always be given a valid string.
You won't be provided any empty strings.
Good luck and for the Alliance!
 */

public class The_Culling_of_Stratholme {
    public static String purify(String s) {
        String result = "";
        String[] strings = s.split(" ");
        StringBuilder sb;
        for (int i = 0; i < strings.length; i++) {
            sb = new StringBuilder(strings[i]);
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == 'i' || sb.charAt(j) == 'I') {
                    sb.setCharAt(j, '%');
                    if (j == 0) {
                        if (sb.length() > 1 && (sb.charAt(j+1)!=' ' && sb.charAt(j+1)!='i' && sb.charAt(j+1)!='I')) {
                            sb.setCharAt(j+1, '%');
                            continue;
                        }
                    }
                    if (j > 0 && j < sb.length()-1) {
                        if (sb.length() > 1 && sb.charAt(j - 1) != ' ' && sb.charAt(j - 1) != 'i' && sb.charAt(j - 1) != 'I') {
                            sb.setCharAt(j-1, '%');
                        }
                        if (sb.length() > 2 && sb.charAt(j + 1) != ' ' && sb.charAt(j + 1) != 'i' && sb.charAt(j + 1) != 'I') {
                            sb.setCharAt(j+1, '%');
                            continue;
                        }
                    }
                    if (j == sb.length()-1) {
                        if (sb.length() > 1 && sb.charAt(j - 1) != ' ' && sb.charAt(j - 1) != 'i' && sb.charAt(j - 1) != 'I') {
                            sb.setCharAt(j-1, '%');
                        }
                    }
                }
            }
            String s1 = sb.toString().replaceAll("%", "");
            if (!s1.isEmpty()) {
                result += s1 + " ";
            }
        }
        return result.trim();
    }
}

