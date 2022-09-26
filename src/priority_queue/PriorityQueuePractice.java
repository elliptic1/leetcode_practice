package priority_queue;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePractice {

    public static void main(String[] args) {

        Solution s = new Solution();

        s.doStuff();

    }

}

class Solution {

    public void doStuff() {

        PriorityQueue<Pair<Integer, Float>> pq = new PriorityQueue<>(1,
                Comparator.comparing(Pair::getValue)
        );

        pq.add(new Pair<>(4, 5f));
        pq.add(new Pair<>(5, 2f));
        pq.add(new Pair<>(9, 1f));
        pq.add(new Pair<>(1, 1f));
        pq.add(new Pair<>(2, 10f));

        System.out.println(pq);

    }

}
