package leetcode;

import java.util.*;

public class RevealCardsIncreasingOrder {

    static Integer[] deckRevealedIncreasing(Integer[] deck) {
        Arrays.sort(deck);
        Integer[] res = new Integer[deck.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            q.add(i);
        }
        int idx = 0; // track on sorted array
        while (!q.isEmpty()) {
            int res_idx = q.poll();
            res[res_idx] = deck[idx++];
            if (q.isEmpty())
                break;
            q.add(q.poll());
        }
        return res;
    }
    public static void main(String[] args) {
        Integer[] deck = {7,6,5,3,2};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }
}
