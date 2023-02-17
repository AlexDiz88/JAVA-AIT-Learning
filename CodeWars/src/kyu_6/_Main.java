package kyu_6;

import java.util.List;

public class _Main {
    public static void main(String[] args) {

        // Highest Scoring Word
        //System.out.println(Highest_Scoring_Word.high("adawa adaw hhghd rte zzzzzzz"));

        // Who won the election
        System.out.println(Who_won_the_election.getWinner(List.of("B", "A", "A", "B", "B")));
        System.out.println(Who_won_the_election.getWinner(List.of("A", "A", "B", "B")));
        System.out.println(Who_won_the_election.getWinner(List.of("A", "B", "C", "D")));
        System.out.println(Who_won_the_election.getWinner(List.of("A", "A", "A", "B", "B", "C")));

    }
}
