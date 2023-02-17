package kyu_7;

/*
An infinite number of shelves are arranged one above the other in a staggered fashion.
The cat can jump up to 3 shelves at the same time: from shelf 1 to shelf 2 or 4
(the cat cannot climb on the shelf directly above its head)
Input
Start and finish shelf numbers (always positive integers, finish no smaller than start)
Task
Find the minimum number of jumps to go from start to finish
Example
Start 1, finish 5, then answer is 2 (1 => 4 => 5 or 1 => 2 => 5)
 */

public class Cats_and_shelves {
    public static int solution(int start, int finish) {
        return (finish - start) / 3 + (finish - start) % 3;
    }
}
