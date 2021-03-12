package google.moving_average_from_stream;

import java.util.concurrent.LinkedBlockingQueue;

public class MovingAverageWithQueue {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(5);

        ma.next(3);
        ma.next(3);
        ma.next(3);
        ma.next(3);
        ma.next(3);
        ma.next(5);
        ma.next(5);
        ma.next(5);
        ma.next(5);
        ma.next(5);
        ma.next(5);
        ma.next(5);
        ma.next(5);
    }
}

class MovingAverage {

    int size = 0;
    LinkedBlockingQueue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedBlockingQueue<>(size);
    }

    public double next(int val) {
        if (q.size() == size) {
            q.remove();
        }
        q.add(val);
        int sum = q.stream().mapToInt(it -> it).sum();
        return sum / (1.0 * q.size());
    }

}

