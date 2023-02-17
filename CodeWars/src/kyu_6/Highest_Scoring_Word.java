package kyu_6;

/*
Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
For example, the score of abad is 8 (1 + 2 + 1 + 4).
You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.
All letters will be lowercase and all inputs will be valid.
 */

public class Highest_Scoring_Word {
    public static String high(String s) {
        String[] arr = s.split(" ");
        int[] resArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                resArray[i] += arr[i].charAt(j)-96;
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < resArray.length; i++) {
            if (resArray[i] > resArray[maxIndex]) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }
}
