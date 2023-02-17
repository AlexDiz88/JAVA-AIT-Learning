package kyu_7;

/*
Write a function consonantCount, consonant_count or ConsonantCount that takes a string of English-language text
and returns the number of consonants in the string.

Consonants are all letters used to write English excluding the vowels a, e, i, o, u.
 */

public class Count_consonants {
    public static int getCount(String str) {
        int counter = 0;
        String compare = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            boolean flag = false;
            if (Character.isLetter(str.charAt(i))) {
                for (int j = 0; j < compare.length(); j++) {
                    if (str.charAt(i) == compare.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) counter++;
            }
        }
        return counter;
    }
}
